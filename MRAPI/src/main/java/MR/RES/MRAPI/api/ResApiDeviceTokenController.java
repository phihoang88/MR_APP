package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.MDeviceToken;
import MR.RES.MRAPI.model.ResponseObject;
import MR.RES.MRAPI.model.TTableInfo;
import MR.RES.MRAPI.service.MDeviceTokenRepository;
import MR.RES.MRAPI.service.TTableInfoRepository;
import MR.RES.MRAPI.system.Common;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DeviceToken")
public class ResApiDeviceTokenController {
    @Autowired
    MDeviceTokenRepository deviceTokenRepository;

    @RequestMapping(value = "/getByDeviceId/{deviceId}", method = RequestMethod.GET)
    ResponseEntity<ResponseObject> getByDeviceId(@PathVariable("deviceId") String deviceId){
        Optional<MDeviceToken> deviceToken = null;
        try{
            deviceToken = deviceTokenRepository.findByDeviceId(deviceId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed","get device token by device id successfully!",deviceToken)
            );
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed","get device token by device id failed!",null)
            );
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ResponseEntity<ResponseObject> insertToken(@RequestBody MDeviceToken deviceToken){
        try{
            List<MDeviceToken> mDeviceToken = deviceTokenRepository.findAll();
            if(mDeviceToken.size() > 0){
                for(int i = 0 ;i <= mDeviceToken.size() - 1 ; i ++){
                    if(deviceToken.getDeviceId().equals(mDeviceToken.get(i).getDeviceId())){
                        MDeviceToken newData = new MDeviceToken(
                                mDeviceToken.get(i).getId(),
                                mDeviceToken.get(i).getDeviceId(),
                                deviceToken.getDeviceTokenOld(),
                                deviceToken.getDeviceTokenNew()
                        );
                        // insert
                        return ResponseEntity.status(HttpStatus.OK).body(
                                new ResponseObject("success","Update device token successfully!",deviceTokenRepository.save(newData))
                        );
                    }
                }
                // insert
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Insert device token successfully!",deviceTokenRepository.save(deviceToken))
                );
            }
            else{
                // insert
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success","Insert device token successfully!",deviceTokenRepository.save(deviceToken))
                );
            }
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed",exception.getMessage().toString(),"")
            );
        }
    }


}
