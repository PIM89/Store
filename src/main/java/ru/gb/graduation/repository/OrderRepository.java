package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
