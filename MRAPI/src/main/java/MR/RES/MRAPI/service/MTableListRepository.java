package MR.RES.MRAPI.service;
import org.springframework.data.jpa.repository.Query;

import MR.RES.MRAPI.model.MTableList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MTableListRepository extends JpaRepository<MTableList, Integer> {

    @Query(value = "SELECT tb1.table_id as table_id, \n" +
            "tb1.table_nm_vn as table_nm_vn, \n" +
            "tb1.table_nm_en as table_nm_en,\n" +
            "tb1.table_nm_jp as table_nm_jp,\n" +
            "tb1.sort_no as sort_no,\n" +
            "tb1.table_ava as table_ava,\n" +
            "tb2.BOOK_DT as book_dt,\n" +
            "tb2.IS_END as is_end,\n" +
            "tb2.NOTE_TX as note_tx,\n" +
            "tb2.SERVE_DATETIME as serve_datetime,\n" +
            "tb2.TABLE_INFO_ID as table_info_id,\n" +
            "tb2.TABLE_STT_ID as table_stt_id ,\n" +
            "case when tb3.attr1_tx Is null or tb2.IS_END = '1'\n" +
            "then 'Emptying' \n" +
            "else tb3.attr1_tx \n" +
            "end as table_stt_nm \n" +
            "FROM m_table_list tb1\n" +
            "left join t_table_info tb2\n" +
            "on   tb1.table_id = tb2.TABLE_ID\n" +
            "and  tb2.DEL_FG <> '1' \n" +
            "left join m_hanyo tb3\n" +
            "on  tb2.table_stt_id = tb3.hanyo_id\n" +
            "where tb1.del_fg <> '1' \n" +
            "order by CAST(sort_no AS UNSIGNED) asc ", nativeQuery = true)
    List<Object[]> getListTableDisplay();

}