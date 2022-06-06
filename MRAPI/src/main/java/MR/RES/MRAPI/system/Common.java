package MR.RES.MRAPI.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Common {
    private String systemDateTimeString;

    public Common(){}

    public String getSystemDateTimeString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        systemDateTimeString = dtf.format(now);
        return systemDateTimeString;
    }
}
