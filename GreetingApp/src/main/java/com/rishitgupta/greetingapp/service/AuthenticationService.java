package com.rishitgupta.greetingapp.service;



import com.rishitgupta.greetingapp.dto.AuthUserDTO;
import com.rishitgupta.greetingapp.model.AuthUser;
import com.rishitgupta.greetingapp.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;


@Service
public class AuthenticationService {

    private final AuthUserRepository authUserRepository;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public AuthenticationService(AuthUserRepository authUserRepository,
                                 AuthenticationManager authManager, JwtService jwtService,
                                 BCryptPasswordEncoder encoder) {
        this.authUserRepository = authUserRepository;
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    public String register(AuthUserDTO authUserDTO) {
        if (authUserRepository.findByUsername(authUserDTO.getUsername()).isPresent()) {
            return "Username is already taken.";
        }
        AuthUser user = new AuthUser();
        user.setFirstName(authUserDTO.getFirstName());
        user.setLastName(authUserDTO.getLastName());
        user.setUsername(authUserDTO.getUsername());
        user.setEmail(authUserDTO.getEmail());
        user.setPassword(encoder.encode(authUserDTO.getPassword()));

        authUserRepository.save(user);
        return "User registered successfully!";
    }

    public String login(AuthUserDTO authUserDTO) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authUserDTO.getUsername(), authUserDTO.getPassword())
        );

        if (authentication.isAuthenticated()) {
            // Retrieve UserDetails from the authentication object
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtService.generateToken(userDetails);
        }
        return "Authentication failed.";
    }


}