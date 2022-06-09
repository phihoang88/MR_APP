package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Queries.TableOrdering;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.service.TTableOrderRepository;
import MR.RES.MRAPI.system.Common;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/TableOrder")
public class RestApiTableOrderController {

    @Autowired
    TTableOrderRepository tableOrderRepository;

    @RequestMapping(value = "/getOrderingList/{tableInfoId}", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListOrdering(@PathVariable("tableInfoId") Integer tableInfoId) {
        List<Object[]> tableOrderings = tableOrderRepository.getListOrdering(tableInfoId);
        if (tableOrderings.size() == 0){
            return ResponseEntity.status(HttpStatus.OK).body (
                    new ResponseObject("success","Get table ordering list success", null));
        }
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
                    orderDatas.get(14),
                    orderDatas.get(15)
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
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
}
