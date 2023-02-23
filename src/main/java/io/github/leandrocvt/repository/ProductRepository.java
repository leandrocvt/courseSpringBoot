package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}
