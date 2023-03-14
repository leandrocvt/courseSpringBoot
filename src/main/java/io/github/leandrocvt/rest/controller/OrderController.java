package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.rest.dto.OrderDTO;
import io.github.leandrocvt.service.OrderService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody OrderDTO dto){
        OrderModel orderModel = service.save(dto);
        return orderModel.getId();
    }

}
