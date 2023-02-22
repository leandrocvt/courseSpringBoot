package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

    List<ClientModel> findByNameLike(String name);

}
