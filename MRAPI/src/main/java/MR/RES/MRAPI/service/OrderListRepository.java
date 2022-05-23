package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}