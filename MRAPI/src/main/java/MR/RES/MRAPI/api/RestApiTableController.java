package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MTableList;
import MR.RES.MRAPI.model.Queries.OrderItemInfo;
import MR.RES.MRAPI.model.Queries.OrderListByProduct;
import MR.RES.MRAPI.model.Queries.TableDevice.TableDevice;
import MR.RES.MRAPI.model.Queries.TableInfo.TableInfoList;
import MR.RES.MRAPI.model.Queries.TableOrdering;
import MR.RES.MRAPI.model.Requests.TableStatus;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.service.MTableListRepository;
import MR.RES.MRAPI.service.TTableInfoRepository;
import MR.RES.MRAPI.service.TTableOrderRepository;
import MR.RES.MRAPI.system.Common;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import MR.RES.MRAPI.model.ResponseObject;
import com.google.gson.Gson;

import java.util.*;

@RestController
@RequestMapping("/api/Table")
public class RestApiTableController {

    @Autowired
    MTableListRepository tableListRepository;
    @Autowired
    TTableOrderRepository tableOrderRepository;
    @Autowired
    TTableInfoRepository tableInfoRepository;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> listAllTable(){
        List<MTableList> listTable= tableListRepository.findAll();
        if(listTable.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body (
                    new ResponseObject("success","Empty list", null));
        }
        return ResponseEntity.status(HttpStatus.OK).body (
                new ResponseObject("success","Get list successfully", listTable));
    }

    @RequestMapping(value = "/listTable/{id}", method = RequestMethod.GET)
    public MTableList getTableById(@PathVariable("id") Integer id) {
        MTableList table= tableListRepository.getOne(id);
        if(table == null) {
            ResponseEntity.notFound().build();
        }
        return table;
    }

    @RequestMapping(value = "/getProductOrderList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getProductOrderList() {
        List<Object[]> productOrders = tableOrderRepository.getListProductOrder();
        if (productOrders.size() == 0){
            return ResponseEntity.status(HttpStatus.OK).body (
                   new ResponseObject("success","Get product ordering list success", null));
        }
        String json;
        Gson gson;
        List<Object> results = new ArrayList<>();

        List<OrderItemInfo> lstOrderItem = null;
        OrderListByProduct orderListByProduct = null;
        Long currId = null;
        Long nextId = null;

        for(int i = 0 ; i <= productOrders.size() - 1; i ++){
            List<Object> orderDatas = Arrays.stream(productOrders.get(i)).toList();
            //get each id row
            nextId = Long.parseLong(orderDatas.get(8).toString());
            if(currId == null){
                currId = Long.parseLong(orderDatas.get(8).toString());
                lstOrderItem = new ArrayList<OrderItemInfo>();
                orderListByProduct = new OrderListByProduct(
                        orderDatas.get(8),
                        orderDatas.get(9),
                        orderDatas.get(10),
                        orderDatas.get(11),
                        orderDatas.get(12),
                        orderDatas.get(13),
                        orderDatas.get(14),
                        null
                );
            } else if (currId != nextId) {
                orderListByProduct.setOrderItemInfos(lstOrderItem);
                gson = new Gson();
                json = gson.toJson(orderListByProduct);
                OrderListByProduct orderJson = gson.fromJson(json, OrderListByProduct.class);
                results.add(orderJson);

                currId = nextId;
                lstOrderItem = new ArrayList<OrderItemInfo>();
                orderListByProduct = new OrderListByProduct(
                        orderDatas.get(8),
                        orderDatas.get(9),
                        orderDatas.get(10),
                        orderDatas.get(11),
                        orderDatas.get(12),
                        orderDatas.get(13),
                        orderDatas.get(14),
                        null
                );
            }
            OrderItemInfo orderItemInfo = new OrderItemInfo(
                    orderDatas.get(0),
                    orderDatas.get(1),
                    orderDatas.get(2),
                    orderDatas.get(3),
                    orderDatas.get(4),
                    orderDatas.get(5),
                    orderDatas.get(6),
                    orderDatas.get(7));
            lstOrderItem.add(orderItemInfo);
        }
        orderListByProduct.setOrderItemInfos(lstOrderItem);
        gson = new Gson();
        json = gson.toJson(orderListByProduct);
        OrderListByProduct orderJson = gson.fromJson(json, OrderListByProduct.class);
        results.add(orderJson);

        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get product ordering list success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get product ordering list false", null)
                );
    }

    @RequestMapping(value = "/placeDevice/{tableId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> placeDevice(@PathVariable("tableId") Integer tableId, @RequestBody String deviceId){
        try{
            String devId = new JSONObject(deviceId).get("deviceId").toString();
            List<MTableList> tableLst = tableListRepository.findAll();
            List<MTableList> rmDevices = new ArrayList<MTableList>();
            if(tableLst.size() > 0){
                for(int i = 0 ; i <= tableLst.size() - 1; i++){
                    if(tableLst.get(i).getDeviceId() != null){
                        if (tableLst.get(i).getDeviceId().equals(devId)){
                            MTableList model = tableLst.get(i);
                            model.setDeviceId("");
                            rmDevices.add(model);
                        }
                    }
                }
                if(rmDevices.size() > 0){
                    tableListRepository.saveAll(rmDevices);
                }
            }

            String date = new Common().getSystemDateTimeString();
            Optional<MTableList> mTableList = tableListRepository.findById(tableId)
                    .map(info -> {
                        info.setDeviceId(devId);
                        info.setUpdDt(date);
                        info.setUpdUserId("huy");
                        info.setUpdPgmId("Table Screen");
                        return tableListRepository.save(info);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Update device for table successfully!",mTableList)
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/getInfoByDeviceId/{deviceId}", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getInfoByDeviceId(@PathVariable("deviceId") String deviceId) {
        try {
            List<Object[]> tableInfo = tableListRepository.getTableInfoByDeviceId(deviceId);
            if (tableInfo.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "Cannot get table by device id", null));
            }
            String json;
            Gson gson;
            List<Object> tabInfo = Arrays.stream(tableInfo.get(0)).toList();
            gson = new Gson();
            json = gson.toJson(new TableDevice(
                    tabInfo.get(0),
                    tabInfo.get(1),
                    tabInfo.get(2),
                    tabInfo.get(3)
            ));
            TableDevice tableDevice = gson.fromJson(json, TableDevice.class);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Get table device list success", tableDevice));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "Get table device list false", null)
            );
        }
    }
}
