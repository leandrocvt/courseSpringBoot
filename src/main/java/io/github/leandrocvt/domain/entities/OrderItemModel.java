package io.github.leandrocvt.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemModel {

    private Integer id;
    private OrderModel order;
    private ProductModel product;
    private Integer quantity;

}
