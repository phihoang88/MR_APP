package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Notification.NotificationRequestDto;
import MR.RES.MRAPI.model.Notification.SubscriptionRequestDto;
import MR.RES.MRAPI.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/subscribe")
    public void subscribeToTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationService.subscribeToTopic(subscriptionRequestDto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeFromTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationService.unsubscribeFromTopic(subscriptionRequestDto);
    }

    @PostMapping("/sendtodevice")
    public String sendPnsToDevice(@RequestBody NotificationRequestDto notificationRequestDto) {
        return notificationService.sendPnsToDevice(notificationRequestDto);
    }

    @PostMapping("/sendtotopic")
    public String sendPnsToTopic(@RequestBody NotificationRequestDto notificationRequestDto) throws JsonProcessingException {
        return notificationService.sendPnsToTopic(notificationRequestDto);
    }
}
