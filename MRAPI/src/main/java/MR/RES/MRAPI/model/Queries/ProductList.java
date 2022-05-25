package MR.RES.MRAPI.model.Queries;

public class ProductList {

    private Object product_id;
    private Object product_nm_vn;
    private Object product_nm_en;
    private Object product_nm_jp;
    private Object price;
    private Object price_show;
    private Object description;
    private Object product_avatar;
    private Object menu_id;

    public ProductList() {
    }

    public ProductList(Object product_id, Object product_nm_vn, Object product_nm_en, Object product_nm_jp, Object price, Object price_show, Object description, Object product_avatar, Object menu_id) {
        this.product_id = product_id;
        this.product_nm_vn = product_nm_vn;
        this.product_nm_en = product_nm_en;
        this.product_nm_jp = product_nm_jp;
        this.price = price;
        this.price_show = price_show;
        this.description = description;
        this.product_avatar = product_avatar;
        this.menu_id = menu_id;
    }

    public Object getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Object product_id) {
        this.product_id = product_id;
    }

    public Object getProduct_nm_vn() {
        return product_nm_vn;
    }

    public void setProduct_nm_vn(Object product_nm_vn) {
        this.product_nm_vn = product_nm_vn;
    }

    public Object getProduct_nm_en() {
        return product_nm_en;
    }

    public void setProduct_nm_en(Object product_nm_en) {
        this.product_nm_en = product_nm_en;
    }

    public Object getProduct_nm_jp() {
        return product_nm_jp;
    }

    public void setProduct_nm_jp(Object product_nm_jp) {
        this.product_nm_jp = product_nm_jp;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getPrice_show() {
        return price_show;
    }

    public void setPrice_show(Object price_show) {
        this.price_show = price_show;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getProduct_avatar() {
        return product_avatar;
    }

    public void setProduct_avatar(Object product_avatar) {
        this.product_avatar = product_avatar;
    }

    public Object getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Object menu_id) {
        this.menu_id = menu_id;
    }
}
