package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_device_token")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MDeviceToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_id", length = 30)
    private String deviceId;

    @Column(name = "device_token_old", length = 200)
    private String deviceTokenOld;

    @Column(name = "device_token_new", length = 200)
    private String deviceTokenNew;

    public MDeviceToken() {
    }

    public MDeviceToken(Integer id, String deviceId, String deviceTokenOld, String deviceTokenNew) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceTokenOld = deviceTokenOld;
        this.deviceTokenNew = deviceTokenNew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTokenOld() {
        return deviceTokenOld;
    }

    public void setDeviceTokenOld(String deviceTokenOld) {
        this.deviceTokenOld = deviceTokenOld;
    }

    public String getDeviceTokenNew() {
        return deviceTokenNew;
    }

    public void setDeviceTokenNew(String deviceTokenNew) {
        this.deviceTokenNew = deviceTokenNew;
    }
}