package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
