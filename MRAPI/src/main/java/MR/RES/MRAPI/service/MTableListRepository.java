package MR.RES.MRAPI.service;
import org.springframework.data.jpa.repository.Query;

import MR.RES.MRAPI.model.MTableList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MTableListRepository extends JpaRepository<MTableList, Integer> {
}