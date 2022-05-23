package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MProduct;
import MR.RES.MRAPI.service.MProductRepository;
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
public class ResApiProductController {
    @Autowired
    MProductRepository productRepository;

    @RequestMapping(value = "/listProduct", method = RequestMethod.GET)
    public ResponseEntity<List<MProduct>> listAllTable(){
        List<MProduct> listTable= productRepository.findAll();
        if(listTable.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MProduct>>(listTable, HttpStatus.OK);
    }

    @RequestMapping(value = "/listProduct/{id}", method = RequestMethod.GET)
    public MProduct getTableById(@PathVariable("id") Integer id) {
        MProduct table= productRepository.getOne(id);
        if(table == null) {
            ResponseEntity.notFound().build();
        }
        return table;
    }
}
