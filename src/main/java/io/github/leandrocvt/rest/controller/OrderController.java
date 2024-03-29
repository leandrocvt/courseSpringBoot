package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.OrderItemModel;
import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.domain.enums.OrderStatus;
import io.github.leandrocvt.rest.dto.OrderDTO;
import io.github.leandrocvt.rest.dto.OrderInformationDTO;
import io.github.leandrocvt.rest.dto.OrderItemInformationDTO;
import io.github.leandrocvt.rest.dto.UpdateOrderStatusDTO;
import io.github.leandrocvt.service.OrderService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public Integer save(@RequestBody @Valid OrderDTO dto){
        OrderModel orderModel = service.save(dto);
        return orderModel.getId();
    }

    @GetMapping("{id}")
    public OrderInformationDTO getById(@PathVariable Integer id){
        return service.getFullOrder(id)
                .map( o -> convert(o))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Order not found!"));
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable Integer id, @RequestBody UpdateOrderStatusDTO dto){
        String newStatus = dto.getNewStatus();
        service.updateStatus(id, OrderStatus.valueOf(newStatus));
    }

    private OrderInformationDTO convert(OrderModel orderModel){
        return OrderInformationDTO
                .builder().id(orderModel.getId())
                .orderDate(orderModel.getOrderDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(orderModel.getClient().getCpf())
                .nameClient(orderModel.getClient().getName())
                .total(orderModel.getTotal())
                .status(orderModel.getStatus().name())
                .items(convert(orderModel.getItems()))
                .build();
    }

    private List<OrderItemInformationDTO> convert(List<OrderItemModel> items){
        if (CollectionUtils.isEmpty(items)){
            return Collections.emptyList();
        }

        return items.stream().map( item -> OrderItemInformationDTO.builder()
                .description(item.getProduct().getDescription())
                .priceUnity(item.getProduct().getPriceUnity())
                .quantity(item.getQuantity())
                .build()
        ).collect(Collectors.toList());
    }

}
