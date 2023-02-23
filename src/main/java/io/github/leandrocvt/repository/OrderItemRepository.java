package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, Integer> {
}
