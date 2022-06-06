package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Queries.TableInfo.TableInfoList;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.service.TTableInfoRepository;
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
@RequestMapping("/api/TableInfo")
public class ResApiTableInfoController {

    @Autowired
    TTableInfoRepository tableInfoRepository;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListTable() {
        List<Object[]> tableInfoDisplays = tableInfoRepository.getListTableDisplay();
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
                    tableDatas.get(12),
                    tableDatas.get(13),
                    tableDatas.get(14),
                    tableDatas.get(15),
                    tableDatas.get(16)
                    ));
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
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

    @RequestMapping(value = "/receiveCalling/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> receiveCalling(@PathVariable("tableInfoId") Integer tableInfoId){
        try{
            String date = new Common().getSystemDateTimeString();
            Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfoId)
                    .map(info -> {
                        info.setIsCalling('0');
                        info.setUpdDt(date);
                        info.setUpdUserId("huy");
                        info.setUpdPgmId("Table Screen");
                        return tableInfoRepository.save(info);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Update Calling status successfully",tTableInfo)
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/receiveCheckout/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> receiveCheckout(@PathVariable("tableInfoId") Integer tableInfoId){
        try{
            String date = new Common().getSystemDateTimeString();
            Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfoId)
                    .map(info -> {
                        info.setIsCheckout('0');
                        info.setUpdDt(date);
                        info.setUpdUserId("huy");
                        info.setUpdPgmId("Table Screen");
                        return tableInfoRepository.save(info);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Update Check out status successfully",tTableInfo)
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/updateNote/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> updateNote(@PathVariable("tableInfoId") Integer tableInfoId, @RequestBody String noteTx){
        try{
            String date = new Common().getSystemDateTimeString();
            Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfoId)
                    .map(info -> {
                        info.setNoteTx(noteTx);
                        info.setUpdDt(date);
                        info.setUpdUserId("huy");
                        info.setUpdPgmId("Table Order Screen");
                        return tableInfoRepository.save(info);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Update Note successfully",tTableInfo)
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }


}
