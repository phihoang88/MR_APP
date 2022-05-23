package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MMenuRepository extends JpaRepository<MMenu, Integer> {
}