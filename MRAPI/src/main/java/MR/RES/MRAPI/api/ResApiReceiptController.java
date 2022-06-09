package MR.RES.MRAPI.api;
import MR.RES.MRAPI.model.Queries.Receipt.OrderListForReceipt;
import MR.RES.MRAPI.model.Queries.Receipt.ProductForReceiptItem;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.model.TTableReceipt;
import MR.RES.MRAPI.service.ReceiptRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/Receipt")
public class ResApiReceiptController {

    @Autowired
    ReceiptRepository receiptRepository;

    @RequestMapping(value = "/getListOrderForReceipt", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListOrderForReceipt() {
        List<Object[]> orderForReceipts = receiptRepository.getListOrderForReceipt();
        if(orderForReceipts.size() == 0){
            return ResponseEntity.status(HttpStatus.OK).body (
                    new ResponseObject("success","Get ordering list for receipt success", null));
        }
        List<Object> results = new ArrayList<>();
        String json;
        Gson gson;

        List<ProductForReceiptItem> lstOrderItem = null;
        OrderListForReceipt orderListForReceipt = null;
        Long currId = null;
        Long nextId = null;

        for(int i = 0 ; i <= orderForReceipts.size() - 1; i ++){
            List<Object> orderDatas = Arrays.stream(orderForReceipts.get(i)).toList();
            //get each id row
            nextId = Long.parseLong(orderDatas.get(0).toString());
            if(currId == null){
                currId = Long.parseLong(orderDatas.get(0).toString());
                lstOrderItem = new ArrayList<ProductForReceiptItem>();
                orderListForReceipt = new OrderListForReceipt(
                        orderDatas.get(0),
                        orderDatas.get(1),
                        orderDatas.get(12),
                        orderDatas.get(2),
                        orderDatas.get(3),
                        orderDatas.get(4),
                        null
                );
            } else if (currId != nextId) {
                orderListForReceipt.setListProducts(lstOrderItem);
                gson = new Gson();
                json = gson.toJson(orderListForReceipt);
                OrderListForReceipt orderJson = gson.fromJson(json, OrderListForReceipt.class);
                results.add(orderJson);

                currId = nextId;
                lstOrderItem = new ArrayList<ProductForReceiptItem>();
                orderListForReceipt = new OrderListForReceipt(
                        orderDatas.get(0),
                        orderDatas.get(1),
                        orderDatas.get(12),
                        orderDatas.get(2),
                        orderDatas.get(3),
                        orderDatas.get(4),
                        null
                );
            }
            ProductForReceiptItem orderItemInfo = new ProductForReceiptItem(
                    orderDatas.get(5),
                    orderDatas.get(6),
                    orderDatas.get(7),
                    orderDatas.get(8),
                    orderDatas.get(9),
                    orderDatas.get(10),
                    orderDatas.get(11),
                    orderDatas.get(1)
                    );
            lstOrderItem.add(orderItemInfo);
        }
        orderListForReceipt.setListProducts(lstOrderItem);
        gson = new Gson();
        json = gson.toJson(orderListForReceipt);
        OrderListForReceipt orderJson = gson.fromJson(json, OrderListForReceipt.class);
        results.add(orderJson);

        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get ordering list for receipt success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get ordering list for receipt false", null)
                );
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertReceipt(@RequestBody TTableReceipt tableReceipt){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Insert Receipt successfully!",receiptRepository.save(tableReceipt))
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }
}
