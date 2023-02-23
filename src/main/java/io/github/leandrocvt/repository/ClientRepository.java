package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

    @Query(value = " select c from ClientModel c where c.name like :name ")
    List<ClientModel> findByName(@Param("name") String name);

    @Query(value = " delete from ClientModel c where c.name = :name")
    @Modifying
    void deleteByName(String name);

    boolean existsByName(String name);

}
