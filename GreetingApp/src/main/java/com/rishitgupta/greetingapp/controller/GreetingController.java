package com.rishitgupta.greetingapp.controller;


import com.rishitgupta.greetingapp.DTO.Greeting;
import com.rishitgupta.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }


    @PostMapping
    public Greeting createGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    @PutMapping
    public String updateGreeting() {
        return greetingService.updateGreeting();
    }

    @DeleteMapping
    public String deleteGreeting() {
        return greetingService.deleteGreeting();
    }
}