package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Contact;
import MR.RES.MRAPI.service.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> listAllContact(){
        List<Contact> listContact= contactRepository.findAll();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact getContactById(@PathVariable("id") Integer id) {
        Contact contact= contactRepository.getOne(id);
        if(contact == null) {
            ResponseEntity.notFound().build();
        }
        return contact;
    }
}