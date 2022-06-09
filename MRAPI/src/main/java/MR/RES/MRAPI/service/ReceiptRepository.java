package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.TTableReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<TTableReceipt, Integer>{
    @Query(value = "select tb1.table_info_id,\n" +
            "       tb1.product_order_stt_id,\n" +
            "       tb4.table_nm_vn,\n" +
            "       tb4.table_nm_en,\n" +
            "       tb4.table_nm_jp,\n" +
            "       tb1.product_id,\n" +
            "       tb2.product_nm_vn,\n" +
            "       tb2.product_nm_en,\n" +
            "       tb2.product_nm_jp,\n" +
            "       sum(tb1.count) as count,\n" +
            "       tb2.price,\n" +
            "       tb2.price_show, \n" +
            "       tb3.is_end \n" +
            "from   t_table_order tb1\n" +
            "join   m_product     tb2\n" +
            "on     tb1.product_id = tb2.product_id\n" +
            "join   t_table_info  tb3\n" +
            "on     tb1.table_info_id = tb3.table_info_id\n" +
            "join   m_table_list  tb4\n" +
            "on     tb3.table_id = tb4.table_id\n" +
            "group by tb1.table_info_id,\n" +
            "         tb1.product_id\n" +
            "order by tb1.table_info_id,\n" +
            "\t     tb1.product_order_stt_id,\n" +
            "         tb4.table_nm_vn" ,nativeQuery = true)
    List<Object[]> getListOrderForReceipt();

}
