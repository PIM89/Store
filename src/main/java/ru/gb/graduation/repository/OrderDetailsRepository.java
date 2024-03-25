package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
