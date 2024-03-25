package ru.gb.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.graduation.model.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
