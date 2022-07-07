package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MDeviceToken;
import MR.RES.MRAPI.model.MTableList;
import MR.RES.MRAPI.model.TTableBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TTableBookRepository extends JpaRepository<TTableBook,Integer> {

    @Query(value = "select\n" +
            "\ttb1.book_id,\n" +
            "\ttb1.table_id,\n" +
            "    tb2.table_nm_vn,\n" +
            "    tb2.table_nm_en,\n" +
            "    tb2.table_nm_jp,\n" +
            "    tb2.table_ava,\n" +
            "    tb1.guess_nm,\n" +
            "    tb1.guess_phone,\n" +
            "    tb1.guess_count,\n" +
            "    tb1.note_tx,\n" +
            "    tb1.book_date,\n" +
            "    tb1.book_time_from,\n" +
            "    tb1.book_time_to,\n" +
            "\ttb1.is_cancel,\n" +
            "\ttb1.is_end\n" +
            " from t_table_book tb1 \n" +
            " join m_table_list tb2\n" +
            " on   tb1.table_id = tb2.table_id\n" +
            " where tb1.del_fg <> '1'\n" +
            " and   tb2.del_fg <> '1'\n" +
            " order by tb1.book_time_to desc,tb1.is_cancel, tb1.table_id \n" +
            " ",nativeQuery = true)
    List<Object[]> getListTableBook();

    @Query(value = "select * \n" +
            "from t_table_book\n" +
            "where table_id = ?1\n" +
            "and   book_date = ?2\n" +
            "and   is_cancel = '0'\n" +
            "and   is_end = '0'\n" +
            "and   cast(book_time_to as time) > current_time()",nativeQuery = true)
    List<Object[]> getExistTableBookInsert(Integer tableId, String bookDate);

    @Query(value = "select * \n" +
            "from t_table_book\n" +
            "where table_id = ?1\n" +
            "and   book_date = ?2\n" +
            "and   is_cancel = '0'\n" +
            "and   is_end = '0'\n" +
            "and   book_id <> ?3\n" +
            "and   cast(book_time_to as time) > current_time()",nativeQuery = true)
    List<Object[]> getExistTableBookUpdate(Integer tableId, String bookDate, Integer bookId);

    @Query(value = "select book_id\n" +
            "from t_table_book\n" +
            "where table_id = ?1\n" +
            "and   is_cancel = '0'\n" +
            "and   is_end    = '0'\n" +
            "and   book_date = cast(current_date as varchar(20))\n" +
            "and   cast(book_time_from as time) < current_time",nativeQuery = true)
    List<Object[]> getListOrderInTableAfterCheckout(Integer tableId);
}
