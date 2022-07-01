package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.TTableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TTableInfoRepository extends JpaRepository<TTableInfo, Integer> {
    @Query(value = "SELECT tb1.table_id as table_id,\n" +
            "tb1.table_nm_vn as table_nm_vn, \n" +
            "tb1.table_nm_en as table_nm_en,\n" +
            "tb1.table_nm_jp as table_nm_jp,\n" +
            "tb1.sort_no as sort_no,\n" +
            "tb1.table_ava as table_ava,\n" +
            "tb4.BOOK_DATE as book_dt,\n" +
            "tb4.BOOK_TIME_FROM as book_tm_from,\n" +
            "tb4.BOOK_TIME_TO as book_tm_to,\n" +
            "tb2.IS_END as is_end,\n" +
            "tb2.NOTE_TX as note_tx,\n" +
            "tb2.SERVE_DATE as serve_date,\n" +
            "tb2.SERVE_TIME as serve_time,\n" +
            "tb2.TABLE_INFO_ID as table_info_id,\n" +
            "tb2.TABLE_STT_ID as table_stt_id ,\n" +
            "case when tb4.table_id Is not null \n" +
            "\t\t  then 'Booking'\n" +
            "     when tb3.attr1_tx Is null or tb2.IS_END = '1'\n" +
            "          then 'Emptying'\n" +
            "\t else tb3.attr1_tx \n" +
            "end as table_stt_nm, \n" +
            "tb2.is_calling as is_calling, \n" +
            "tb2.is_checkout as is_checkout, \n" +
            "tb2.guess_nm, \n" +
            " tb2.guess_count, \n" +
            " tb2.guess_phone \n" +
            " FROM m_table_list tb1\n" +
            "left join t_table_info tb2\n" +
            "on   tb1.table_id = tb2.TABLE_ID\n" +
            "and  tb2.IS_END <> '1' \n" +
            "and  tb2.DEL_FG <> '1' \n" +
            "and  tb2.serve_date = replace(cast(current_date as varchar(20)),'-','')\n" +
            "left join m_hanyo tb3\n" +
            "on  tb2.table_stt_id = tb3.hanyo_id\n" +
            "left join t_table_book tb4\n" +
            "on tb1.table_id = tb4.table_id\n" +
            "and tb4.is_cancel = '0'\n" +
            "and tb4.is_end = '0'\n" +
            "and tb4.book_date = cast(current_date as varchar(20))\n" +
            "where tb1.del_fg <> '1' \n" +
            "order by CAST(sort_no AS UNSIGNED) asc", nativeQuery = true)
    List<Object[]> getListTableDisplay();
}
