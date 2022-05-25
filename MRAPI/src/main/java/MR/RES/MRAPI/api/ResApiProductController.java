package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MProduct;
import MR.RES.MRAPI.model.Queries.ProductList;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.service.MProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/Product")
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

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getListProductByMenuId() {
        List<Object[]> proLists = productRepository.getListProduct();
        String json;
        Gson gson;

        List<Object> results = new ArrayList<>();
        for(int i = 0 ; i <= proLists.size() - 1; i ++){
            List<Object> proRow = Arrays.stream(proLists.get(i)).toList();
            gson = new Gson();
            json = gson.toJson(new ProductList(
                                proRow.get(0),
                                proRow.get(1),
                                proRow.get(2),
                                proRow.get(3),
                                proRow.get(4),
                                proRow.get(5),
                                proRow.get(6),
                                proRow.get(7),
                                proRow.get(8)));
            ProductList modelJson = gson.fromJson(json, ProductList.class);
            results.add(modelJson);
        }
        return results.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body (
                        new ResponseObject("success","Get product list success", results)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("failed","Get product list false", null)
                );
    }

}
