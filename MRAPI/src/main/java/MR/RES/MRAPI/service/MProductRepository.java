package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MProductRepository extends JpaRepository<MProduct, Integer> {
}