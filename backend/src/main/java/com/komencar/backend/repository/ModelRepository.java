package com.komencar.backend.repository;

import com.komencar.backend.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findBySegment_Id(long s_id);

    List<Model> findByNameLike(String keyword);
}
