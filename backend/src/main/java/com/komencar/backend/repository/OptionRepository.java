package com.komencar.backend.repository;

import com.komencar.backend.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByModelDetail_Id(int md_id);
}
