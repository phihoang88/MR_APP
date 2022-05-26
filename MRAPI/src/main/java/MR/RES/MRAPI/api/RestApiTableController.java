package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MTableList;
import MR.RES.MRAPI.model.Queries.TableInfoList;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.service.MTableListRepository;
import MR.RES.MRAPI.service.TTableInfoRepository;
import MR.RES.MRAPI.service.TTableOrderRepository;
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

import javax.persistence.Column;
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


    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListTable() {
        List<Object[]> tableInfoDisplays = tableListRepository.getListTableDisplay();
        String json;
        Gson gson;

        List<Object> results = new ArrayList<>();
        for(int i = 0 ; i <= tableInfoDisplays.size() - 1; i ++){
            List<Object> tableDatas = Arrays.stream(tableInfoDisplays.get(i)).toList();
            gson = new Gson();
            json = gson.toJson(new TableInfoList(
                                tableDatas.get(0),
                                tableDatas.get(1),
                                tableDatas.get(2),
                                tableDatas.get(3),
                                tableDatas.get(4),
                                tableDatas.get(5),
                                tableDatas.get(6),
                                tableDatas.get(7),
                                tableDatas.get(8),
                                tableDatas.get(9),
                                tableDatas.get(10),
                                tableDatas.get(11),
                                tableDatas.get(12)));
            TableInfoList tableInfoList = gson.fromJson(json, TableInfoList.class);
            results.add(tableInfoList);
        }
        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get table list success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get table list false", null)
                );
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


}
