package MR.RES.MRAPI.model.Queries;

public class TableOrdering {
    private Object table_order_id;
    private Object table_info_id;
    private Object product_id;
    private Object count;
    private Object product_order_stt_id;
    private Object order_dt;
    private Object done_dt;
    private Object description;
    private Object menu_id;
    private Object price;
    private Object price_show;
    private Object product_avatar;
    private Object product_nm_en;
    private Object product_nm_jp;
    private Object product_nm_vn;

    public TableOrdering() {
    }

    public TableOrdering(Object table_order_id, Object table_info_id, Object product_id, Object count, Object product_order_stt_id, Object order_dt, Object done_dt, Object description, Object menu_id, Object price, Object price_show, Object product_avatar, Object product_nm_en, Object product_nm_jp, Object product_nm_vn) {
        this.table_order_id = table_order_id;
        this.table_info_id = table_info_id;
        this.product_id = product_id;
        this.count = count;
        this.product_order_stt_id = product_order_stt_id;
        this.order_dt = order_dt;
        this.done_dt = done_dt;
        this.description = description;
        this.menu_id = menu_id;
        this.price = price;
        this.price_show = price_show;
        this.product_avatar = product_avatar;
        this.product_nm_en = product_nm_en;
        this.product_nm_jp = product_nm_jp;
        this.product_nm_vn = product_nm_vn;
    }

    public Object getTable_order_id() {
        return table_order_id;
    }

    public void setTable_order_id(Object table_order_id) {
        this.table_order_id = table_order_id;
    }

    public Object getTable_info_id() {
        return table_info_id;
    }

    public void setTable_info_id(Object table_info_id) {
        this.table_info_id = table_info_id;
    }

    public Object getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Object product_id) {
        this.product_id = product_id;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public Object getProduct_order_stt_id() {
        return product_order_stt_id;
    }

    public void setProduct_order_stt_id(Object product_order_stt_id) {
        this.product_order_stt_id = product_order_stt_id;
    }

    public Object getOrder_dt() {
        return order_dt;
    }

    public void setOrder_dt(Object order_dt) {
        this.order_dt = order_dt;
    }

    public Object getDone_dt() {
        return done_dt;
    }

    public void setDone_dt(Object done_dt) {
        this.done_dt = done_dt;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Object menu_id) {
        this.menu_id = menu_id;
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

    public Object getProduct_avatar() {
        return product_avatar;
    }

    public void setProduct_avatar(Object product_avatar) {
        this.product_avatar = product_avatar;
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

    public Object getProduct_nm_vn() {
        return product_nm_vn;
    }

    public void setProduct_nm_vn(Object product_nm_vn) {
        this.product_nm_vn = product_nm_vn;
    }
}
