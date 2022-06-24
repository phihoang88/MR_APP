package MR.RES.MRAPI.api;

import MR.RES.MRAPI.model.Notification.NotificationRequestDto;
import MR.RES.MRAPI.model.Notification.SubscriptionRequestDto;
import MR.RES.MRAPI.service.NotificationGuessService;
import MR.RES.MRAPI.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificationguess")
public class NotificationGuessController {

    @Autowired
    private NotificationGuessService notificationGuessService;

    @PostMapping("/subscribe")
    public void subscribeToTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationGuessService.subscribeToTopic(subscriptionRequestDto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribeFromTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        notificationGuessService.unsubscribeFromTopic(subscriptionRequestDto);
    }

    @PostMapping("/sendtodevice")
    public String sendPnsToDevice(@RequestBody NotificationRequestDto notificationRequestDto) {
        return notificationGuessService.sendPnsToDevice(notificationRequestDto);
    }

    @PostMapping("/sendtotopic")
    public String sendPnsToTopic(@RequestBody NotificationRequestDto notificationRequestDto) throws JsonProcessingException {
        return notificationGuessService.sendPnsToTopic(notificationRequestDto);
    }
}