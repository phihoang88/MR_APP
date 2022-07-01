package MR.RES.MRAPI.api;


import MR.RES.MRAPI.model.Queries.TableBook.TableBookList;
import MR.RES.MRAPI.model.Queries.TableInfo.TableInfoList;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableBook;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.service.TTableBookRepository;
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
@RequestMapping("/api/TableBook")
public class ResApiTableBookController {

    @Autowired
    TTableBookRepository tTableBookRepository;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResponseEntity<ResponseObject> createBookTable(@RequestBody TTableBook tableBook){
        try{
            List<Object[]> existsBookLst = tTableBookRepository.getExistTableBookInsert(
                    tableBook.getTableId(),
                    tableBook.getBookDate()
                    );
            if(existsBookLst.size() > 0){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Can not book in a same time.",existsBookLst.get(0))
                );
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Insert Book successfully!",tTableBookRepository.save(tableBook))
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/insertOrUpdateBook", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertTableInfo(@RequestBody TTableBook tableBook){
        try{
            if(tableBook.getId() == null){
                List<Object[]> existsBookLst = tTableBookRepository.getExistTableBookInsert(
                        tableBook.getTableId(),
                        tableBook.getBookDate()
                );
                if(existsBookLst.size() > 0){
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new ResponseObject("failed","Can not book in a same time.",existsBookLst.get(0))
                    );
                }
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Insert Book successfully!",tTableBookRepository.save(tableBook))
                );
            }
            else{
                List<Object[]> existsBookLst = tTableBookRepository.getExistTableBookUpdate(
                        tableBook.getTableId(),
                        tableBook.getBookDate(),
                        tableBook.getId()
                );
                if(existsBookLst.size() > 0){
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new ResponseObject("failed","Can not book in a same time.",existsBookLst.get(0))
                    );
                }
                //update
                String date = new Common().getSystemDateTimeString();
                Optional<TTableBook> objBook = tTableBookRepository.findById(tableBook.getId())
                        .map(info -> {
                            info.setTableId(tableBook.getTableId());
                            info.setBookDate(tableBook.getBookDate());
                            info.setBookTimeFrom(tableBook.getBookTimeFrom());
                            info.setBookTimeTo(tableBook.getBookTimeTo());
                            info.setGuessNm(tableBook.getGuessNm());
                            info.setGuessPhone(tableBook.getGuessPhone());
                            info.setGuessCount(tableBook.getGuessCount());
                            info.setNoteTx(tableBook.getNoteTx());
                            info.setUpdDt(date);
                            info.setUpdUserId(tableBook.getCrtUserId());
                            info.setUpdPgmId(tableBook.getCrtPgmId());
                            return tTableBookRepository.save(info);
                        });
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Update Book info successfully",objBook)
                );
            }
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListBookTable(){
        try{
            List<Object[]> lstTableBook = tTableBookRepository.getListTableBook();
            if(lstTableBook.size() == 0){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Empty list",null)
                );
            }
            String json;
            Gson gson;

            List<Object> results = new ArrayList<>();
            for(int i = 0 ; i <= lstTableBook.size() - 1; i ++){
                List<Object> tableDatas = Arrays.stream(lstTableBook.get(i)).toList();
                gson = new Gson();
                json = gson.toJson(new TableBookList(
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
                        tableDatas.get(14)
                ));
                TableBookList tableInfoList = gson.fromJson(json, TableBookList.class);
                results.add(tableInfoList);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","Get List successfully",results)
            );
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }

    @RequestMapping(value = "/cancelBook/{bookId}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObject> cancelTableBook(@PathVariable("bookId") Integer bookId){
        String date = new Common().getSystemDateTimeString();
        Optional<TTableBook> tableBook = tTableBookRepository.findById(bookId)
                .map(info -> {
                    info.setIsCancel('1');
                    info.setUpdDt(date);
                    info.setUpdUserId("002");
                    info.setUpdPgmId("Book Screen");
                    return tTableBookRepository.save(info);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success","Update Cancel Table successfully",tableBook)
        );
    }
}
