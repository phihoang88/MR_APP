package MR.RES.MRAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MMenu  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Integer id;

    @Column(name = "menu_nm_vn", length = 30)
    private String menuNmVn;

    @Column(name = "menu_nm_jp", length = 30)
    private String menuNmJp;

    @Column(name = "menu_nm_en", length = 30)
    private String menuNmEn;

    @Column(name = "menu_img", length = 200)
    private String menuImg;

    @Column(name = "note", length = 200)
    private String note;

    @Column(name = "crt_dt", nullable = false, length = 20)
    private String crtDt;

    @Column(name = "crt_user_id", nullable = false, length = 40)
    private String crtUserId;

    @Column(name = "crt_pgm_id", nullable = false, length = 20)
    private String crtPgmId;

    @Column(name = "upd_dt", nullable = false, length = 20)
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

    public String getMenuNmVn() {
        return menuNmVn;
    }

    public void setMenuNmVn(String menuNmVn) {
        this.menuNmVn = menuNmVn;
    }

    public String getMenuNmJp() {
        return menuNmJp;
    }

    public void setMenuNmJp(String menuNmJp) {
        this.menuNmJp = menuNmJp;
    }

    public String getMenuNmEn() {
        return menuNmEn;
    }

    public void setMenuNmEn(String menuNmEn) {
        this.menuNmEn = menuNmEn;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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