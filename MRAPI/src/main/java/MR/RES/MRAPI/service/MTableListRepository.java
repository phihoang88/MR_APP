package MR.RES.MRAPI.service;
import org.springframework.data.jpa.repository.Query;

import MR.RES.MRAPI.model.MTableList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MTableListRepository extends JpaRepository<MTableList, Integer> {

    @Query(value = "select table_id,\n" +
            "\t   table_nm_vn,\n" +
            "       table_nm_en,\n" +
            "       table_nm_jp\n" +
            "from   m_table_list\n" +
            "where  device_id = ?1 \n" +
            "and    del_fg <> '1'", nativeQuery = true)
    List<Object[]> getTableInfoByDeviceId(String deviceId);
}