package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_table_receipt")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TTableReceipt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_receipt_id", nullable = false)
    private Integer id;

    @Column(name = "table_info_id", nullable = false)
    private Integer tableInfoId;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "discount_amount")
    private String discountAmount;

    @Column(name = "vat",nullable = false)
    private Integer vat;

    @Column(name = "other_fee")
    private String otherFee;

    @Column(name = "note_tx")
    private String noteTx;

    @Column(name = "payment_stt_id")
    private Character paymentSttId;

    @Column(name = "total", nullable = false, length = 50)
    private String total;

    @Column(name = "cash", nullable = false, length = 50)
    private String cash;

    @Column(name = "crt_dt", nullable = false, length = 20)
    private String crtDt;

    @Column(name = "crt_user_id", nullable = false, length = 40)
    private String crtUserId;

    @Column(name = "crt_pgm_id", nullable = false, length = 20)
    private String crtPgmId;

    @Column(name = "upd_dt", length = 20)
    private String updDt;

    @Column(name = "upd_user_id", length = 40)
    private String updUserId;

    @Column(name = "upd_pgm_id", length = 20)
    private String updPgmId;

    @Column(name = "del_fg", nullable = false)
    private Character delFg;

    public TTableReceipt() {
    }

    public TTableReceipt(Integer id, Integer tableInfoId, Integer discountPercent, String discountAmount, Integer vat, String otherFee, String noteTx, Character paymentSttId, String total, String cash, String crtDt, String crtUserId, String crtPgmId, String updDt, String updUserId, String updPgmId, Character delFg) {
        this.id = id;
        this.tableInfoId = tableInfoId;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.vat = vat;
        this.otherFee = otherFee;
        this.noteTx = noteTx;
        this.paymentSttId = paymentSttId;
        this.total = total;
        this.cash = cash;
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

    public Integer getTableInfoId() {
        return tableInfoId;
    }

    public void setTableInfoId(Integer tableInfoId) {
        this.tableInfoId = tableInfoId;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getNoteTx() {
        return noteTx;
    }

    public void setNoteTx(String noteTx) {
        this.noteTx = noteTx;
    }

    public Character getPaymentSttId() {
        return paymentSttId;
    }

    public void setPaymentSttId(Character paymentSttId) {
        this.paymentSttId = paymentSttId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
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
