package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MUserRepository extends JpaRepository<MUser, String> {
}