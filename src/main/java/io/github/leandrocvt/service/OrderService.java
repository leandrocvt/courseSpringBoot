package io.github.leandrocvt.service;

import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.rest.dto.OrderDTO;

public interface OrderService {

    OrderModel save(OrderDTO dto);
}
