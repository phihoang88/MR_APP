package MR.RES.MRAPI.model.Queries;

public class MenuList {
    private Object menu_id;
    private Object menu_nm_vn;
    private Object menu_nm_en;
    private Object menu_nm_jp;
    private Object menu_img;


    public MenuList() {
    }

    public MenuList(Object menu_id, Object menu_nm_vn, Object menu_nm_en, Object menu_nm_jp, Object menu_img) {
        this.menu_id = menu_id;
        this.menu_nm_vn = menu_nm_vn;
        this.menu_nm_en = menu_nm_en;
        this.menu_nm_jp = menu_nm_jp;
        this.menu_img = menu_img;
    }

    public Object getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Object menu_id) {
        this.menu_id = menu_id;
    }

    public Object getMenu_nm_vn() {
        return menu_nm_vn;
    }

    public void setMenu_nm_vn(Object menu_nm_vn) {
        this.menu_nm_vn = menu_nm_vn;
    }

    public Object getMenu_nm_en() {
        return menu_nm_en;
    }

    public void setMenu_nm_en(Object menu_nm_en) {
        this.menu_nm_en = menu_nm_en;
    }

    public Object getMenu_nm_jp() {
        return menu_nm_jp;
    }

    public void setMenu_nm_jp(Object menu_nm_jp) {
        this.menu_nm_jp = menu_nm_jp;
    }

    public Object getMenu_img() {
        return menu_img;
    }

    public void setMenu_img(Object menu_img) {
        this.menu_img = menu_img;
    }
}
