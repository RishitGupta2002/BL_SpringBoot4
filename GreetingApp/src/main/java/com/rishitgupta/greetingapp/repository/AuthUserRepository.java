package com.rishitgupta.greetingapp.repository;
import com.rishitgupta.greetingapp.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {

    Optional<AuthUser> findByUsername(String username);
}