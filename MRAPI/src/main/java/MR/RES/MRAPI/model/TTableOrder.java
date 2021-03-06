package MR.RES.MRAPI.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_table_order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TTableOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_order_id", nullable = false)
    private Integer id;

    @Column(name = "table_info_id", nullable = false)
    private Integer tableInfoId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "count", nullable = false)
    private String count;

    @Column(name = "product_order_stt_id", nullable = false)
    private String productOrderSttId;

    @Column(name = "product_opt_id")
    private Integer productOptId;

    @Column(name = "opt_count")
    private Integer optCount;

    @Column(name = "order_dt", nullable = false)
    private String orderDt;

    @Column(name = "order_tm", nullable = false)
    private String orderTm;

    @Column(name = "done_dt")
    private String doneDt;

    @Column(name = "done_tm")
    private String doneTm;

    @Column(name = "note_tx")
    private String noteTx;

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

    public TTableOrder() {
    }

    public TTableOrder(Integer id, Integer tableInfoId, Integer productId, String count, String productOrderSttId, Integer productOptId, Integer optCount, String orderDt, String orderTm, String doneDt, String doneTm, String noteTx, String crtDt, String crtUserId, String crtPgmId, String updDt, String updUserId, String updPgmId, Character delFg) {
        this.id = id;
        this.tableInfoId = tableInfoId;
        this.productId = productId;
        this.count = count;
        this.productOrderSttId = productOrderSttId;
        this.productOptId = productOptId;
        this.optCount = optCount;
        this.orderDt = orderDt;
        this.orderTm = orderTm;
        this.doneDt = doneDt;
        this.doneTm = doneTm;
        this.noteTx = noteTx;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProductOrderSttId() {
        return productOrderSttId;
    }

    public void setProductOrderSttId(String productOrderSttId) {
        this.productOrderSttId = productOrderSttId;
    }

    public String getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(String orderDt) {
        this.orderDt = orderDt;
    }

    public String getDoneDt() {
        return doneDt;
    }

    public void setDoneDt(String doneDt) {
        this.doneDt = doneDt;
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

    public String getOrderTm() {
        return orderTm;
    }

    public void setOrderTm(String orderTm) {
        this.orderTm = orderTm;
    }

    public String getDoneTm() {
        return doneTm;
    }

    public void setDoneTm(String doneTm) {
        this.doneTm = doneTm;
    }

    public Integer getProductOptId() {
        return productOptId;
    }

    public void setProductOptId(Integer productOptId) {
        this.productOptId = productOptId;
    }

    public Integer getOptCount() {
        return optCount;
    }

    public void setOptCount(Integer optCount) {
        this.optCount = optCount;
    }

    public String getNoteTx() {
        return noteTx;
    }

    public void setNoteTx(String noteTx) {
        this.noteTx = noteTx;
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