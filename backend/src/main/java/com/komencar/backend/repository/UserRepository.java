package com.komencar.backend.repository;

import com.komencar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "from User where u_email=:u_email")
    User findByUserEmail(@Param("u_email") String u_email);

}