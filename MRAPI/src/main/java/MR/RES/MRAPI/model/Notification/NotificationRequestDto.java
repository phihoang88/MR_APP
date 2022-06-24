package MR.RES.MRAPI.model.Notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
public class NotificationRequestDto {

    private String target;
    private String title;
    private String body;
    @JsonInclude(Include.NON_NULL)
    private NotificationDataDto notificationDataDto;


    public NotificationRequestDto(String target, String title, String body, NotificationDataDto notificationDataDto) {
        this.target = target;
        this.title = title;
        this.body = body;
        this.notificationDataDto = notificationDataDto;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public NotificationDataDto getNotificationDataDto() {
        return notificationDataDto;
    }

    public void setNotificationDataDto(NotificationDataDto notificationDataDto) {
        this.notificationDataDto = notificationDataDto;
    }
}