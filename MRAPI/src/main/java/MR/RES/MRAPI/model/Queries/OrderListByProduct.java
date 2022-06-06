package MR.RES.MRAPI.model.Queries;
import java.util.List;
public class OrderListByProduct {
    private Object product_id;
    private Object product_nm_vn;
    private Object product_nm_en;
    private Object product_nm_jp;
    private Object price;
    private Object price_show;
    private Object product_avatar;

    private List<OrderItemInfo> orderItemInfos;

    public OrderListByProduct() {
    }

    public OrderListByProduct(Object product_id, Object product_nm_vn, Object product_nm_en, Object product_nm_jp, Object price, Object price_show, Object product_avatar, List<OrderItemInfo> orderItemInfos) {
        this.product_id = product_id;
        this.product_nm_vn = product_nm_vn;
        this.product_nm_en = product_nm_en;
        this.product_nm_jp = product_nm_jp;
        this.price = price;
        this.price_show = price_show;
        this.product_avatar = product_avatar;
        this.orderItemInfos = orderItemInfos;
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

    public Object getProduct_avatar() {
        return product_avatar;
    }

    public void setProduct_avatar(Object product_avatar) {
        this.product_avatar = product_avatar;
    }

    public List<OrderItemInfo> getOrderItemInfos() {
        return orderItemInfos;
    }

    public void setOrderItemInfos(List<OrderItemInfo> orderItemInfos) {
        this.orderItemInfos = orderItemInfos;
    }
}
