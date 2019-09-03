package me.fengqijun.oauthserverdemo.repository;

import me.fengqijun.oauthserverdemo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID>, UserRepositoryCustom {
    Optional<User> findByEmailIgnoreCase(String email);
}
