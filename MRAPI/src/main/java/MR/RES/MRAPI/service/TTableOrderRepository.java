package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.TTableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TTableOrderRepository extends JpaRepository<TTableOrder, Integer> {

    @Query(value = "select \n" +
            "\ttb1.table_order_id,\n" +
            "\ttb1.table_info_id,\n" +
            "    tb1.product_id,\n" +
            "\ttb1.count, \n" +
            "    tb1.product_order_stt_id,\n" +
            "    tb1.order_dt,\n" +
            "    tb1.done_dt,\n" +
            "    tb1.note_tx,\n" +
            "    tb2.description,\n" +
            "\ttb2.menu_id,\n" +
            "\ttb2.price,\n" +
            "\ttb2.price_show,\n" +
            "\ttb2.product_avatar,\n" +
            "\ttb2.product_nm_en,\n" +
            "\ttb2.product_nm_jp,\n" +
            "\ttb2.product_nm_vn\n" +
            "from t_table_order tb1,\n" +
            "     m_product     tb2\n" +
            "where tb1.product_id = tb2.product_id\n" +
            "and   tb1.TABLE_INFO_ID = ?1\n" +
            "and   tb1.del_fg <> '1'\n" +
            "order by tb1.table_order_id\n", nativeQuery = true)
    List<Object[]> getListOrdering(Integer tableInfoId);


    @Query(value = "select sum(tb1.count) as count,\n" +
            "       tb1.product_order_stt_id,\n" +
            "       tb2.table_id,\n" +
            "       tb2.table_info_id,\n" +
            "       tb4.table_nm_vn,\n" +
            "       tb4.table_nm_en,\n" +
            "       tb4.table_nm_jp,\n" +
            "       tb1.order_tm, \n" +
            "\t   tb3.product_id,\n" +
            "       tb3.product_nm_vn,\n" +
            "       tb3.product_nm_en,\n" +
            "       tb3.product_nm_jp,\n" +
            "       tb3.price,\n" +
            "       tb3.price_show,\n" +
            "       tb3.product_avatar\n" +
            "from   t_table_order  tb1\n" +
            "join   t_table_info   tb2\n" +
            "on     tb1.table_info_id = tb2.table_info_id\n" +
            "join   m_product      tb3\n" +
            "on     tb1.product_id    = tb3.product_id\n" +
            "join   m_table_list   tb4\n" +
            "on     tb4.table_id      = tb2.table_id\n" +
            "where  tb1.product_order_stt_id = 0\n" +
            "group by tb1.product_id,\n" +
            "         tb1.product_order_stt_id,\n" +
            "         tb2.table_id\n" +
            "order by tb1.product_id,tb2.table_id",nativeQuery = true)
    List<Object[]> getListProductOrder();

}
