package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.LoginParams;
import MR.RES.MRAPI.model.MUser;
import MR.RES.MRAPI.service.MUserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import MR.RES.MRAPI.model.ResponseObject;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/User")
public class ResApiUserController {
    @Autowired
    MUserRepository userListRepository;

    //login api
    @RequestMapping(value = "/login", consumes="application/json", produces ="application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> checkLogin(@RequestBody LoginParams loginInfo){
        Optional<MUser> user = userListRepository.findById(loginInfo.getUsernameOrEmail());

        if(user.isPresent() && user.get().getPassword().equals(loginInfo.getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success","User Exists","yes")
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed","User Not Exist","")
            );
        }
    }







}
