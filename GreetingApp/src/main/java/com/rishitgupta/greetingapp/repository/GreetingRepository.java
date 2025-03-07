package com.rishitgupta.greetingapp.repository;

import com.rishitgupta.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}