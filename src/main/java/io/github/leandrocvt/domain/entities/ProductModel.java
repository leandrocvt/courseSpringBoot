package io.github.leandrocvt.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {

    private Integer id;
    private String description;
    private BigDecimal price;
}
