package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String username);
    boolean existsByName(String userName);
}
