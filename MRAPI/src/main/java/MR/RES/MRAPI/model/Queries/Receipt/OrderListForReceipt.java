package MR.RES.MRAPI.model.Queries.Receipt;
import java.util.List;
public class OrderListForReceipt {

    private Object table_info_id;
    private Object product_order_stt_id;

    private Object table_nm_vn;
    private Object table_nm_en;
    private Object table_nm_jp;
    private List<ProductForReceiptItem> listProducts;

    public OrderListForReceipt() {
    }

    public OrderListForReceipt(Object table_info_id, Object product_order_stt_id, Object table_nm_vn, Object table_nm_en, Object table_nm_jp, List<ProductForReceiptItem> listProducts) {
        this.table_info_id = table_info_id;
        this.product_order_stt_id = product_order_stt_id;
        this.table_nm_vn = table_nm_vn;
        this.table_nm_en = table_nm_en;
        this.table_nm_jp = table_nm_jp;
        this.listProducts = listProducts;
    }

    public Object getTable_info_id() {
        return table_info_id;
    }

    public void setTable_info_id(Object table_info_id) {
        this.table_info_id = table_info_id;
    }

    public Object getProduct_order_stt_id() {
        return product_order_stt_id;
    }

    public void setProduct_order_stt_id(Object product_order_stt_id) {
        this.product_order_stt_id = product_order_stt_id;
    }

    public List<ProductForReceiptItem> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ProductForReceiptItem> listProducts) {
        this.listProducts = listProducts;
    }

    public Object getTable_nm_vn() {
        return table_nm_vn;
    }

    public void setTable_nm_vn(Object table_nm_vn) {
        this.table_nm_vn = table_nm_vn;
    }

    public Object getTable_nm_en() {
        return table_nm_en;
    }

    public void setTable_nm_en(Object table_nm_en) {
        this.table_nm_en = table_nm_en;
    }

    public Object getTable_nm_jp() {
        return table_nm_jp;
    }

    public void setTable_nm_jp(Object table_nm_jp) {
        this.table_nm_jp = table_nm_jp;
    }
}
