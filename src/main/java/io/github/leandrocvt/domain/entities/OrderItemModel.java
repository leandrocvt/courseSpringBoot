package io.github.leandrocvt.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_request")
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private OrderModel order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @Column(name = "quantity")
    private Integer quantity;

}
