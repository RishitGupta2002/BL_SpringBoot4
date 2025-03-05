package com.rishitgupta.greetingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishitgupta.greetingapp.model.Greeting;


@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}