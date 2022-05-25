package MR.RES.MRAPI.model.Queries;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;


public class TableInfoList {

    @SerializedName("table_id")
    @Expose
    private Object table_id;
    @SerializedName("table_nm_vn")
    @Expose
    private Object table_nm_vn;
    @SerializedName("table_nm_en")
    @Expose
    private Object table_nm_en;
    @SerializedName("table_nm_jp")
    @Expose
    private Object table_nm_jp;
    @SerializedName("sort_no")
    @Expose
    private Object sort_no;
    @SerializedName("table_ava")
    @Expose
    private Object table_ava;
    @SerializedName("book_dt")
    @Expose
    private Object book_dt;
    @SerializedName("is_end")
    @Expose
    private Object is_end;
    @SerializedName("note_tx")
    @Expose
    private Object note_tx;
    @SerializedName("serve_datetime")
    @Expose
    private Object serve_datetime;
    @SerializedName("table_info_id")
    @Expose
    private Object table_info_id;
    @SerializedName("table_stt_id")
    @Expose
    private Object table_stt_id;
    @SerializedName("table_stt_nm")
    @Expose
    private  Object table_stt_nm;


    public TableInfoList() {
    }

    public TableInfoList(Object table_id, Object table_nm_vn, Object table_nm_en, Object table_nm_jp, Object sort_no, Object table_ava, Object book_dt, Object is_end, Object note_tx, Object serve_datetime, Object table_info_id, Object table_stt_id, Object table_stt_nm) {
        this.table_id = table_id;
        this.table_nm_vn = table_nm_vn;
        this.table_nm_en = table_nm_en;
        this.table_nm_jp = table_nm_jp;
        this.sort_no = sort_no;
        this.table_ava = table_ava;
        this.book_dt = book_dt;
        this.is_end = is_end;
        this.note_tx = note_tx;
        this.serve_datetime = serve_datetime;
        this.table_info_id = table_info_id;
        this.table_stt_id = table_stt_id;
        this.table_stt_nm = table_stt_nm;
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

    public Object getSort_no() {
        return sort_no;
    }

    public void setSort_no(Object sort_no) {
        this.sort_no = sort_no;
    }

    public Object getTable_ava() {
        return table_ava;
    }

    public void setTable_ava(Object table_ava) {
        this.table_ava = table_ava;
    }

    public Object getBook_dt() {
        return book_dt;
    }

    public void setBook_dt(Object book_dt) {
        this.book_dt = book_dt;
    }

    public Object getIs_end() {
        return is_end;
    }

    public void setIs_end(Object is_end) {
        this.is_end = is_end;
    }

    public Object getNote_tx() {
        return note_tx;
    }

    public void setNote_tx(Object note_tx) {
        this.note_tx = note_tx;
    }

    public Object getServe_datetime() {
        return serve_datetime;
    }

    public void setServe_datetime(Object serve_datetime) {
        this.serve_datetime = serve_datetime;
    }

    public Object getTable_info_id() {
        return table_info_id;
    }

    public void setTable_info_id(Object table_info_id) {
        this.table_info_id = table_info_id;
    }

    public Object getTable_stt_id() {
        return table_stt_id;
    }

    public void setTable_stt_id(Object table_stt_id) {
        this.table_stt_id = table_stt_id;
    }

    public Object getTable_stt_nm() {
        return table_stt_nm;
    }

    public void setTable_stt_nm(Object table_stt_nm) {
        this.table_stt_nm = table_stt_nm;
    }
}
