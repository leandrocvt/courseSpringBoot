package io.github.leandrocvt.domain.entities;

import io.github.leandrocvt.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItemModel> items;

}
