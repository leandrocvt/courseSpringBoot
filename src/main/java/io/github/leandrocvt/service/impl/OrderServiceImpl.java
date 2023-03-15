package io.github.leandrocvt.service.impl;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.domain.entities.OrderItemModel;
import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.domain.entities.ProductModel;
import io.github.leandrocvt.exception.BusinessRuleException;
import io.github.leandrocvt.repository.ClientRepository;
import io.github.leandrocvt.repository.OrderItemRepository;
import io.github.leandrocvt.repository.OrderRepository;
import io.github.leandrocvt.repository.ProductRepository;
import io.github.leandrocvt.rest.dto.OrderDTO;
import io.github.leandrocvt.rest.dto.OrderItemDTO;
import io.github.leandrocvt.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    private final OrderItemRepository orderItemRepository;

    @Override
    @Transactional
    public OrderModel save(OrderDTO dto) {
        Integer idClient = dto.getClient();
        ClientModel clientModel = clientRepository
                .findById(idClient)
                .orElseThrow(() -> new BusinessRuleException("Id client invalid!"));

        OrderModel orderModel = new OrderModel();
        orderModel.setTotal(dto.getTotal());
        orderModel.setOrderDate(LocalDate.now());
        orderModel.setClient(clientModel);

        List<OrderItemModel> itemsOrder = convertItems(orderModel, dto.getItems());
        repository.save(orderModel);
        orderItemRepository.saveAll(itemsOrder);
        orderModel.setItems(itemsOrder);

        return orderModel;
    }

    @Override
    public Optional<OrderModel> getFullOrder(Integer id) {
        return repository.findByIdFetchItems(id);
    }

    private List<OrderItemModel> convertItems(OrderModel orderModel, List<OrderItemDTO> items){
        if (items.isEmpty()){
            throw new BusinessRuleException("Unable to place an order without items!");
        }

        return items.stream().map( dto -> {
            Integer idProduct = dto.getProduct();
            ProductModel productModel =  productRepository.findById(idProduct)
                    .orElseThrow(() -> new BusinessRuleException("Id Product invalid: " + idProduct));

            OrderItemModel orderItemModel = new OrderItemModel();
            orderItemModel.setQuantity(dto.getQuantity());
            orderItemModel.setOrder(orderModel);
            orderItemModel.setProduct(productModel);
            return orderItemModel;
        }).collect(Collectors.toList());
    }
}
