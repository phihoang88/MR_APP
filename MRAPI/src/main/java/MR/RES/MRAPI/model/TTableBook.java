package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_table_book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TTableBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "table_id", nullable = false)
    private Integer tableId;

    @Column(name = "book_date", nullable = false)
    private String bookDate;

    @Column(name = "book_time_from", nullable = false)
    private String bookTimeFrom;

    @Column(name = "book_time_to", nullable = false)
    private String bookTimeTo;

    @Column(name = "guess_nm", nullable = false)
    private String guessNm;

    @Column(name = "guess_count", nullable = false)
    private String guessCount;

    @Column(name = "guess_phone", nullable = false)
    private String guessPhone;

    @Column(name = "note_tx")
    private String noteTx;

    @Column(name = "is_cancel", nullable = false)
    private Character isCancel;

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

    public TTableBook() {
    }

    public TTableBook(Integer id, Integer tableId, String bookDate, String bookTimeFrom, String bookTimeTo, String guessNm, String guessCount, String guessPhone, String noteTx, Character isCancel, Character isEnd, String crtDt, String crtUserId, String crtPgmId, String updDt, String updUserId, String updPgmId, Character delFg) {
        this.id = id;
        this.tableId = tableId;
        this.bookDate = bookDate;
        this.bookTimeFrom = bookTimeFrom;
        this.bookTimeTo = bookTimeTo;
        this.guessNm = guessNm;
        this.guessCount = guessCount;
        this.guessPhone = guessPhone;
        this.noteTx = noteTx;
        this.isCancel = isCancel;
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

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookTimeFrom() {
        return bookTimeFrom;
    }

    public void setBookTimeFrom(String bookTimeFrom) {
        this.bookTimeFrom = bookTimeFrom;
    }

    public String getBookTimeTo() {
        return bookTimeTo;
    }

    public void setBookTimeTo(String bookTimeTo) {
        this.bookTimeTo = bookTimeTo;
    }

    public String getGuessNm() {
        return guessNm;
    }

    public void setGuessNm(String guessNm) {
        this.guessNm = guessNm;
    }

    public String getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(String guessCount) {
        this.guessCount = guessCount;
    }

    public String getGuessPhone() {
        return guessPhone;
    }

    public void setGuessPhone(String guessPhone) {
        this.guessPhone = guessPhone;
    }

    public String getNoteTx() {
        return noteTx;
    }

    public void setNoteTx(String noteTx) {
        this.noteTx = noteTx;
    }

    public Character getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Character isCancel) {
        this.isCancel = isCancel;
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
