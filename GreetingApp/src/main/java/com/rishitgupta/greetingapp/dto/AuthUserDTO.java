package com.rishitgupta.greetingapp.dto;


import jakarta.validation.constraints.*;

import lombok.Data;
import com.rishitgupta.greetingapp.model.AuthUser;

@Data
public class AuthUserDTO {
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First letter should be uppercase")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First letter should be uppercase")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&*()-+=])(?=.*\\d).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 special character, 1 number, and be 8+ characters long")
    private String password;

    private String username;

    public AuthUser toAuthUser() {
        AuthUser authUser = new AuthUser();
        authUser.setFirstName(firstName);
        authUser.setLastName(lastName);
        authUser.setEmail(email);
        authUser.setPassword(password);
        authUser.setUsername(username);
        return authUser;
    }


}