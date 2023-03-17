package io.github.leandrocvt.rest.dto;

import io.github.leandrocvt.validation.NotEmptyList;
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
    @NotNull(message = "{field.id-client.required}")
    private Integer client;

    @NotNull(message = "{field.total-order.required}")
    private BigDecimal total;

    @NotEmptyList(message = "{field.items-order.required}")
    private List<OrderItemDTO> items;
}
