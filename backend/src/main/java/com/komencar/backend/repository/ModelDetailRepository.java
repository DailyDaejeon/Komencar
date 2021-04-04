package com.komencar.backend.repository;

import com.komencar.backend.model.Model_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ModelDetailRepository extends JpaRepository<Model_Detail, Integer> {
}
