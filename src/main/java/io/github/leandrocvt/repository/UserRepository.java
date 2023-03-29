package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLogin(String login);
}
