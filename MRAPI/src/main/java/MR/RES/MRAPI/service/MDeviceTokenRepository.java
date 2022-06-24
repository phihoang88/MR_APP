package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.MDeviceToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MDeviceTokenRepository extends JpaRepository<MDeviceToken, Integer> {

    Optional<MDeviceToken> findByDeviceId(String deviceId);
}
