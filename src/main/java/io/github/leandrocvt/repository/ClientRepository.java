package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientRepository extends JpaRepository<ClientModel, Integer > {

    @Query(value = " select * from client c where c.name like '%:name%' ", nativeQuery = true)
    List<ClientModel> findByName( @Param("name") String name);

    @Query(" delete from ClientModel c where c.name = :name ")
    @Modifying
    void deleteByName(String name);

    boolean existsByName(String name);

    @Query(" select c from ClientModel c left join fetch c.orders where c.id =:id ")
    ClientModel findClientFetchOrderRepository( @Param("id") Integer id );

}
