package com.komencar.backend.repository;

import com.komencar.backend.model.Subscribe;
import com.komencar.backend.model.SubscribePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, SubscribePK> {
}
