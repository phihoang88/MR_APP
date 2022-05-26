package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MMenuRepository extends JpaRepository<MMenu, Integer> {

    @Query(value = "select menu_id, \n" +
            "\tmenu_nm_vn,\n" +
            "\tmenu_nm_en,\n" +
            "\tmenu_nm_jp,\n" +
            "    menu_img\n" +
            "from m_menu\n" +
            "where del_fg <> '1'",nativeQuery = true)
    List<Object[]> getListMenu();

}