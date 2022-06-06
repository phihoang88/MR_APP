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

    @Column(name = "book_date", length = 10)
    private String bookDt;

    @Column(name = "book_time", length = 10)
    private String bookTm;

    @Column(name = "guess_nm", length = 30)
    private String guessNm;

    @Column(name = "guess_phone", length = 20)
    private String guessPhone;

    @Column(name = "guess_count", length = 10)
    private String guessCount;

    @Column(name = "note_tx", length = 200)
    private String noteTx;

    @Column(name = "serve_date", length = 10)
    private String serveDate;

    @Column(name = "serve_time", length = 10)
    private String serveTime;

    @Column(name = "is_end", nullable = false)
    private Character isEnd;
    @Column(name = "is_calling")
    private Character isCalling;

    @Column(name = "is_checkout")
    private Character isCheckout;

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

    public TTableInfo(Integer id, Integer tableId, Integer tableSttId, String bookDt, String bookTm, String guessNm, String guessPhone, String guessCount, String noteTx, String serveDate, String serveTime, Character isEnd, Character isCalling, Character isCheckout, String crtDt, String crtUserId, String crtPgmId, String updDt, String updUserId, String updPgmId, Character delFg) {
        this.id = id;
        this.tableId = tableId;
        this.tableSttId = tableSttId;
        this.bookDt = bookDt;
        this.bookTm = bookTm;
        this.guessNm = guessNm;
        this.guessPhone = guessPhone;
        this.guessCount = guessCount;
        this.noteTx = noteTx;
        this.serveDate = serveDate;
        this.serveTime = serveTime;
        this.isEnd = isEnd;
        this.isCalling = isCalling;
        this.isCheckout = isCheckout;
        this.crtDt = crtDt;
        this.crtUserId = crtUserId;
        this.crtPgmId = crtPgmId;
        this.updDt = updDt;
        this.updUserId = updUserId;
        this.updPgmId = updPgmId;
        this.delFg = delFg;
    }

    public String getGuessPhone() {
        return guessPhone;
    }

    public void setGuessPhone(String guessPhone) {
        this.guessPhone = guessPhone;
    }

    public String getBookTm() {
        return bookTm;
    }

    public void setBookTm(String bookTm) {
        this.bookTm = bookTm;
    }

    public String getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(String guessCount) {
        this.guessCount = guessCount;
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

    public String getServeDate() {
        return serveDate;
    }

    public void setServeDate(String serveDate) {
        this.serveDate = serveDate;
    }

    public String getServeTime() {
        return serveTime;
    }

    public void setServeTime(String serveTime) {
        this.serveTime = serveTime;
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

    public Character getIsCalling() {
        return isCalling;
    }

    public void setIsCalling(Character isCalling) {
        this.isCalling = isCalling;
    }

    public Character getIsCheckout() {
        return isCheckout;
    }

    public void setIsCheckout(Character isCheckout) {
        this.isCheckout = isCheckout;
    }
}
