package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MTableList;
import MR.RES.MRAPI.model.Queries.OrderItemInfo;
import MR.RES.MRAPI.model.Queries.OrderListByProduct;
import MR.RES.MRAPI.model.Queries.TableOrdering;
import MR.RES.MRAPI.model.Requests.TableStatus;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.service.MTableListRepository;
import MR.RES.MRAPI.service.TTableInfoRepository;
import MR.RES.MRAPI.service.TTableOrderRepository;
import MR.RES.MRAPI.system.Common;
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


    @RequestMapping(value = "/listTable", method = RequestMethod.GET)
    public ResponseEntity<List<MTableList>> listAllTable(){
        List<MTableList> listTable= tableListRepository.findAll();
        if(listTable.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MTableList>>(listTable, HttpStatus.OK);
    }

    @RequestMapping(value = "/listTable/{id}", method = RequestMethod.GET)
    public MTableList getTableById(@PathVariable("id") Integer id) {
        MTableList table= tableListRepository.getOne(id);
        if(table == null) {
            ResponseEntity.notFound().build();
        }
        return table;
    }

    @RequestMapping(value = "/insertOrders", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertOrder(@RequestBody List<TTableOrder> tableOrders){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Insert Order successfully!",tableOrderRepository.saveAll(tableOrders))
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/insertInfos", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertTableInfo(@RequestBody TTableInfo tableInfo){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Insert Table Info successfully!",tableInfoRepository.save(tableInfo))
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }




    @RequestMapping(value = "/insertOrdersFromGuess", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertOrdersFromGuess(@RequestBody List<TTableOrder> tableOrders){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Insert Order successfully!",tableOrderRepository.saveAll(tableOrders))
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }








    @RequestMapping(value = "/getOrderingList/{tableInfoId}", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListOrdering(@PathVariable("tableInfoId") Integer tableInfoId) {
        List<Object[]> tableOrderings = tableOrderRepository.getListOrdering(tableInfoId);
        String json;
        Gson gson;

        List<Object> results = new ArrayList<>();
        for(int i = 0 ; i <= tableOrderings.size() - 1; i ++){
            List<Object> orderDatas = Arrays.stream(tableOrderings.get(i)).toList();
            gson = new Gson();
            json = gson.toJson(new TableOrdering(
                    orderDatas.get(0),
                    orderDatas.get(1),
                    orderDatas.get(2),
                    orderDatas.get(3),
                    orderDatas.get(4),
                    orderDatas.get(5),
                    orderDatas.get(6),
                    orderDatas.get(7),
                    orderDatas.get(8),
                    orderDatas.get(9),
                    orderDatas.get(10),
                    orderDatas.get(11),
                    orderDatas.get(12),
                    orderDatas.get(13),
                    orderDatas.get(14)
                    ));
            TableOrdering tableOrdering = gson.fromJson(json, TableOrdering.class);
            results.add(tableOrdering);
        }
        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get table ordering list success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get table ordering list false", null)
                );
    }

    @RequestMapping(value = "/doneOrder/{tableOrderId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> doneOrder(@PathVariable("tableOrderId") Integer tableOrderId){
        String date = new Common().getSystemDateTimeString();
        Optional<TTableOrder> tTableOrder = tableOrderRepository.findById(tableOrderId)
                                                                .map(order -> {
                                                                    order.setProductOrderSttId("1");
                                                                    order.setDoneDt(date);
                                                                    order.setUpdDt(date);
                                                                    order.setUpdUserId("huy");
                                                                    order.setUpdPgmId("Order Screen");
                                                                    return tableOrderRepository.save(order);
                                                                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success","Update Order Product successfully",tTableOrder)
        );
    }

    @RequestMapping(value = "/updateStt/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> updateTableStatus(@PathVariable("tableInfoId") Integer tableInfoId, @RequestBody TableStatus tableStatus){
        String date = new Common().getSystemDateTimeString();
        Optional<TTableInfo> tableInfo = tableInfoRepository.findById(tableInfoId)
                .map(info -> {
                    info.setTableSttId(tableStatus.getTableStatusId());
                    info.setUpdDt(date);
                    info.setUpdUserId("huy");
                    info.setUpdPgmId("Order Screen");
                    return tableInfoRepository.save(info);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success","Update Table Status successfully",tableInfo)
        );
    }

    @RequestMapping(value = "/getProductOrderList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getProductOrderList() {
        List<Object[]> productOrders = tableOrderRepository.getListProductOrder();
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

}
