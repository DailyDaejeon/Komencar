package com.komencar.backend.repository;

import com.komencar.backend.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
