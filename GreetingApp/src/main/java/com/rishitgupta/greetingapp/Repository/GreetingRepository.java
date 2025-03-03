package com.rishitgupta.greetingapp.Repository;

import com.rishitgupta.greetingapp.DTO.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}