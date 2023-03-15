package io.github.leandrocvt.rest.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInformationDTO {

    private Integer id;
    private String cpf;
    private String nameClient;
    private BigDecimal total;
    private String orderDate;
    private List<OrderItemInformationDTO> items;
}
