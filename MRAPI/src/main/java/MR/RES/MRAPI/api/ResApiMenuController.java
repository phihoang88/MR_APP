package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MMenu;
import MR.RES.MRAPI.model.Notification.Note;
import MR.RES.MRAPI.model.Queries.MenuList;
import MR.RES.MRAPI.service.MMenuRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import MR.RES.MRAPI.model.ResponseObject;

@RestController
@RequestMapping("/api/Menu")
public class ResApiMenuController {
    @Autowired
    MMenuRepository menuListRepository;

    @RequestMapping(value = "/listMenu", method = RequestMethod.GET)
    public ResponseEntity<List<MMenu>> listAllTable(){
        List<MMenu> listTable= menuListRepository.findAll();
        if(listTable.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MMenu>>(listTable, HttpStatus.OK);
    }

    @RequestMapping(value = "/listMenu/{id}", method = RequestMethod.GET)
    public MMenu getTableById(@PathVariable("id") Integer id) {
        MMenu table= menuListRepository.getOne(id);
        if(table == null) {
            ResponseEntity.notFound().build();
        }
        return table;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListMenu() {
        List<Object[]> menuLists = menuListRepository.getListMenu();
        if(menuLists.size() == 0){
            return ResponseEntity.status(HttpStatus.OK).body (
                            new ResponseObject("success","Get menu list success", null));
        }
        String json;
        Gson gson;

        List<Object> results = new ArrayList<>();
        for(int i = 0 ; i <= menuLists.size() - 1; i ++){
            List<Object> menuRow = Arrays.stream(menuLists.get(i)).toList();
            gson = new Gson();
            json = gson.toJson(new MenuList(
                    menuRow.get(0),
                    menuRow.get(1),
                    menuRow.get(2),
                    menuRow.get(3),
                    menuRow.get(4)));
            MenuList menuModel = gson.fromJson(json, MenuList.class);
            results.add(menuModel);
        }
        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get menu list success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get menu list false", null)
                );
    }

}
