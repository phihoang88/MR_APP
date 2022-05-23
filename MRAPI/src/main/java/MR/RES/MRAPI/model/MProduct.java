package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "menu_id", nullable = false)
    private Integer menuId;

    @Column(name = "product_nm_vn", length = 30)
    private String productNmVn;

    @Column(name = "product_nm_jp", length = 30)
    private String productNmJp;

    @Column(name = "product_nm_en", length = 30)
    private String productNmEn;

    @Column(name = "price", nullable = false, length = 40)
    private String price;

    @Column(name = "price_show", nullable = false, length = 20)
    private String priceShow;

    @Column(name = "discount_p", length = 10)
    private String discountP;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "product_avatar", length = 200)
    private String productAvatar;

    @Column(name = "product_stt_id", nullable = false, length = 10)
    private String productSttId;

    @Column(name = "menu_on_position", nullable = false, length = 50)
    private String menuOnPosition;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getProductNmVn() {
        return productNmVn;
    }

    public void setProductNmVn(String productNmVn) {
        this.productNmVn = productNmVn;
    }

    public String getProductNmJp() {
        return productNmJp;
    }

    public void setProductNmJp(String productNmJp) {
        this.productNmJp = productNmJp;
    }

    public String getProductNmEn() {
        return productNmEn;
    }

    public void setProductNmEn(String productNmEn) {
        this.productNmEn = productNmEn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceShow() {
        return priceShow;
    }

    public void setPriceShow(String priceShow) {
        this.priceShow = priceShow;
    }

    public String getDiscountP() {
        return discountP;
    }

    public void setDiscountP(String discountP) {
        this.discountP = discountP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductAvatar() {
        return productAvatar;
    }

    public void setProductAvatar(String productAvatar) {
        this.productAvatar = productAvatar;
    }

    public String getProductSttId() {
        return productSttId;
    }

    public void setProductSttId(String productSttId) {
        this.productSttId = productSttId;
    }

    public String getMenuOnPosition() {
        return menuOnPosition;
    }

    public void setMenuOnPosition(String menuOnPosition) {
        this.menuOnPosition = menuOnPosition;
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