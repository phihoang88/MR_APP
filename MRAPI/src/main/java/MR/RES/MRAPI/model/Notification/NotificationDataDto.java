package MR.RES.MRAPI.model.Notification;

public class NotificationDataDto {

    private Integer table_id;

    private Integer table_info_id;

    private String table_nm_vn;

    private String table_stt_nm;

    private String note_tx;

    public NotificationDataDto(Integer table_id, Integer table_info_id, String table_nm_vn, String table_stt_nm, String note_tx) {
        this.table_id = table_id;
        this.table_info_id = table_info_id;
        this.table_nm_vn = table_nm_vn;
        this.table_stt_nm = table_stt_nm;
        this.note_tx = note_tx;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public Integer getTable_info_id() {
        return table_info_id;
    }

    public void setTable_info_id(Integer table_info_id) {
        this.table_info_id = table_info_id;
    }

    public String getTable_nm_vn() {
        return table_nm_vn;
    }

    public void setTable_nm_vn(String table_nm_vn) {
        this.table_nm_vn = table_nm_vn;
    }

    public String getTable_stt_nm() {
        return table_stt_nm;
    }

    public void setTable_stt_nm(String table_stt_nm) {
        this.table_stt_nm = table_stt_nm;
    }

    public String getNote_tx() {
        return note_tx;
    }

    public void setNote_tx(String note_tx) {
        this.note_tx = note_tx;
    }
}
