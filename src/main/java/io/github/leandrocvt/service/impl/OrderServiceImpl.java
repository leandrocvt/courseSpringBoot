package io.github.leandrocvt.service.impl;

import io.github.leandrocvt.repository.OrderRepository;
import io.github.leandrocvt.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }
}
