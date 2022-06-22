package MR.RES.MRAPI.model.Queries.TableDevice;

public class TableDevice {
    private Object table_id;
    private Object table_nm_vn;
    private Object table_nm_en;
    private Object table_nm_jp;

    public TableDevice(Object table_id, Object table_nm_vn, Object table_nm_en, Object table_nm_jp) {
        this.table_id = table_id;
        this.table_nm_vn = table_nm_vn;
        this.table_nm_en = table_nm_en;
        this.table_nm_jp = table_nm_jp;
    }

    public Object getTable_id() {
        return table_id;
    }

    public void setTable_id(Object table_id) {
        this.table_id = table_id;
    }

    public Object getTable_nm_vn() {
        return table_nm_vn;
    }

    public void setTable_nm_vn(Object table_nm_vn) {
        this.table_nm_vn = table_nm_vn;
    }

    public Object getTable_nm_en() {
        return table_nm_en;
    }

    public void setTable_nm_en(Object table_nm_en) {
        this.table_nm_en = table_nm_en;
    }

    public Object getTable_nm_jp() {
        return table_nm_jp;
    }

    public void setTable_nm_jp(Object table_nm_jp) {
        this.table_nm_jp = table_nm_jp;
    }
}
