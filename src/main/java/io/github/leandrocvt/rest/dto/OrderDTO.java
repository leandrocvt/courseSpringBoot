package io.github.leandrocvt.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull(message = "Enter the customer code!")
    private Integer client;
    @NotNull(message = "Order total field is required!")
    private BigDecimal total;
    private List<OrderItemDTO> items;
}
