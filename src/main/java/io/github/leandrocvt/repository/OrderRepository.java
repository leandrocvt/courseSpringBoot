package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.domain.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
    List<OrderModel> findByClient(ClientModel clientModel);

    @Query("select o from OrderModel o left join fetch o.items where o.id = :id")
    Optional<OrderModel> findByIdFetchItems(@Param("id") Integer id);
}
