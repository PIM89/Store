package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
