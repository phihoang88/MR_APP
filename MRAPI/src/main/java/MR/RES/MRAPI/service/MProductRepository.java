package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MProductRepository extends JpaRepository<MProduct, Integer> {

    @Query(value = "select product_id,\n" +
            "\tproduct_nm_vn,\n" +
            "    product_nm_en,\n" +
            "    product_nm_jp,\n" +
            "    price,\n" +
            "    price_show,\n" +
            "    description,\n" +
            "    product_avatar,\n" +
            "    menu_id\n" +
            "from m_product\n" +
            "where del_fg <> '1'",nativeQuery = true)
    List<Object[]> getListProduct();

}