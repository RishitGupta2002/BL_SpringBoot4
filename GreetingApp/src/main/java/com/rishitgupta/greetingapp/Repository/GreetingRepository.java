package com.rishitgupta.greetingapp.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishitgupta.greetingapp.model.Greeting;


=======
import com.rishitgupta.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

>>>>>>> UC9
@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}