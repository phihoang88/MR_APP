package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_table_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TTableInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_info_id", nullable = false)
    private Integer id;

    @Column(name = "table_id", nullable = false)
    private Integer tableId;

    @Column(name = "table_stt_id", nullable = false)
    private Integer tableSttId;

    @Column(name = "book_dt", nullable = false, length = 20)
    private String bookDt;

    @Column(name = "guess_nm", nullable = false, length = 30)
    private String guessNm;

    @Column(name = "note_tx", nullable = false, length = 200)
    private String noteTx;

    @Column(name = "serve_datetime", nullable = false, length = 20)
    private String serveDatetime;

    @Column(name = "is_end", nullable = false)
    private Character isEnd;

    @Column(name = "crt_dt",nullable = false, length = 20)
    private String crtDt;

    @Column(name = "crt_user_id",nullable = false, length = 40)
    private String crtUserId;

    @Column(name = "crt_pgm_id",nullable = false, length = 20)
    private String crtPgmId;

    @Column(name = "upd_dt", length = 20)
    private String updDt;

    @Column(name = "upd_user_id", length = 40)
    private String updUserId;

    @Column(name = "upd_pgm_id", length = 20)
    private String updPgmId;

    @Column(name = "del_fg", nullable = false)
    private Character delFg;



    public TTableInfo() {
    }

    public TTableInfo(Integer id, Integer tableId, Integer tableSttId, String bookDt, String guessNm, String noteTx, String serveDatetime, Character isEnd, String crtDt, String crtUserId, String crtPgmId, String updDt, String updUserId, String updPgmId, Character delFg) {
        this.id = id;
        this.tableId = tableId;
        this.tableSttId = tableSttId;
        this.bookDt = bookDt;
        this.guessNm = guessNm;
        this.noteTx = noteTx;
        this.serveDatetime = serveDatetime;
        this.isEnd = isEnd;
        this.crtDt = crtDt;
        this.crtUserId = crtUserId;
        this.crtPgmId = crtPgmId;
        this.updDt = updDt;
        this.updUserId = updUserId;
        this.updPgmId = updPgmId;
        this.delFg = delFg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableSttId() {
        return tableSttId;
    }

    public void setTableSttId(Integer tableSttId) {
        this.tableSttId = tableSttId;
    }

    public String getBookDt() {
        return bookDt;
    }

    public void setBookDt(String bookDt) {
        this.bookDt = bookDt;
    }

    public String getGuessNm() {
        return guessNm;
    }

    public void setGuessNm(String guessNm) {
        this.guessNm = guessNm;
    }

    public String getNoteTx() {
        return noteTx;
    }

    public void setNoteTx(String noteTx) {
        this.noteTx = noteTx;
    }

    public String getServeDatetime() {
        return serveDatetime;
    }

    public void setServeDatetime(String serveDatetime) {
        this.serveDatetime = serveDatetime;
    }

    public Character getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Character isEnd) {
        this.isEnd = isEnd;
    }

    public String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    public String getCrtPgmId() {
        return crtPgmId;
    }

    public void setCrtPgmId(String crtPgmId) {
        this.crtPgmId = crtPgmId;
    }

    public String getUpdDt() {
        return updDt;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public String getUpdPgmId() {
        return updPgmId;
    }

    public void setUpdPgmId(String updPgmId) {
        this.updPgmId = updPgmId;
    }

    public Character getDelFg() {
        return delFg;
    }

    public void setDelFg(Character delFg) {
        this.delFg = delFg;
    }

}
