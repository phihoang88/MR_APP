package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MMenu;
import MR.RES.MRAPI.service.MMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
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
}
