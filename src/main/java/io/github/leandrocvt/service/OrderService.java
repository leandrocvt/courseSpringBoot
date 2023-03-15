package io.github.leandrocvt.service;

import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.rest.dto.OrderDTO;

import java.util.Optional;

public interface OrderService {

    OrderModel save(OrderDTO dto);

    Optional<OrderModel> getFullOrder(Integer id);
}
