package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.domain.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

    List<OrderModel> findByClient(ClientModel clientModel);
}
