package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Queries.TableDevice.TableDevice;
import MR.RES.MRAPI.model.Queries.TableInfo.TableInfoList;
import MR.RES.MRAPI.model.Requests.TableStatus;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.model.TTableOrder;
import MR.RES.MRAPI.service.TTableInfoRepository;
import MR.RES.MRAPI.system.Common;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.json.JSONObject;
@RestController
@RequestMapping("/api/TableInfo")
public class ResApiTableInfoController {

    @Autowired
    TTableInfoRepository tableInfoRepository;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListTable() {
        List<Object[]> tableInfoDisplays = tableInfoRepository.getListTableDisplay();
        if(tableInfoDisplays.size() == 0){
            return ResponseEntity.status(HttpStatus.OK).body (
                    new ResponseObject("success","Get table list success", null));
        }
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
                    tableDatas.get(16),
                    tableDatas.get(17),
                    tableDatas.get(18),
                    tableDatas.get(19)
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

    @RequestMapping(value = "/insertOrUpdateBook", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertTableInfo(@RequestBody TTableInfo tableInfo){
        try{
            // insert
            if(tableInfo.getId() == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Insert Table Info successfully!",tableInfoRepository.save(tableInfo))
                );
            }
            else{
                //update
                String date = new Common().getSystemDateTimeString();
                Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfo.getId())
                        .map(info -> {
                            info.setTableId(tableInfo.getTableId());
                            info.setTableSttId(tableInfo.getTableSttId());
                            info.setBookDt(tableInfo.getBookDt());
                            info.setBookTm(tableInfo.getBookTm());
                            info.setGuessNm(tableInfo.getGuessNm());
                            info.setGuessPhone(tableInfo.getGuessPhone());
                            info.setGuessCount(tableInfo.getGuessCount());
                            info.setNoteTx(tableInfo.getNoteTx());
                            info.setUpdDt(date);
                            info.setUpdUserId("huy");
                            info.setUpdPgmId("Table Screen");
                            return tableInfoRepository.save(info);
                        });
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Update Book info successfully",tTableInfo)
                );
            }
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/makeCalling/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> makeCalling(@PathVariable("tableInfoId") Integer tableInfoId){
        try{
            String date = new Common().getSystemDateTimeString();
            Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfoId)
                    .map(info -> {
                        info.setIsCalling('1');
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

    @RequestMapping(value = "/makeCheckout/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> makeCheckout(@PathVariable("tableInfoId") Integer tableInfoId, @RequestBody String deviceToken){
        try{
            String date = new Common().getSystemDateTimeString();
            Optional<TTableInfo> tTableInfo = tableInfoRepository.findById(tableInfoId)
                    .map(info -> {
                        info.setDeviceToken(new JSONObject(deviceToken).get("deviceToken").toString());
                        info.setIsCheckout('1');
                        info.setIsCalling('1');
                        info.setUpdDt(date);
                        info.setUpdUserId("huy");
                        info.setUpdPgmId("Table Screen");
                        return tableInfoRepository.save(info);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Update Checkout status successfully",tTableInfo)
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
                        info.setNoteTx(new JSONObject(noteTx).get("txtNote").toString());
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

    @RequestMapping(value = "/updateAfterCheckout/{tableInfoId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> updateAfterCheckout(@PathVariable("tableInfoId") Integer tableInfoId){
        String date = new Common().getSystemDateTimeString();
        Optional<TTableInfo> tableInfo = tableInfoRepository.findById(tableInfoId)
                .map(info -> {
                    info.setIsCalling('0');
                    info.setIsCheckout('0');
                    info.setIsEnd('1');
                    info.setUpdDt(date);
                    info.setUpdUserId("huy");
                    info.setUpdPgmId("Order Screen");
                    return tableInfoRepository.save(info);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success","Update Table Status successfully",tableInfo)
        );
    }

    @RequestMapping(value = "/getDeviceToken/{tableInfoId}", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getInfoByDeviceId(@PathVariable("tableInfoId") Integer tableInfoId) {
        try {
            Optional<TTableInfo> tableInfo = tableInfoRepository.findById(tableInfoId);
            if (tableInfo.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "Cannot get device token by id", null));
            }

            Gson gson = new Gson();
            String json = gson.toJson(tableInfo.get().getDeviceToken());

            String res = gson.fromJson(json,String.class);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Get device token success", res));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "Get device token false", null)
            );
        }
    }
}
