package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
}
