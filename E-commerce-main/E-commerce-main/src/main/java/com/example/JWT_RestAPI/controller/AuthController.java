package com.example.JWT_RestAPI.controller;

import com.example.JWT_RestAPI.model.LoginRequest;
import com.example.JWT_RestAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        String token = authService.generateToken(request.getUsername());
        return token;
    }


    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {

        String username = authService.extractUsername(token);
        return username;
    }



    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        return "User: " + authentication.getName();
    }


    @Secured("ADMIN")
    @GetMapping("/admin")
    public String onlyAdmin(Authentication authentication) {
        return "Admin: " + authentication.getName();
    }


    @Secured("GERENTEDEPRODUTOS")
    @GetMapping("/gerentedeprodutos")
    public String onlygerentedeprodutos(Authentication authentication) {
        return "gerentedeprodutos: " + authentication.getName();
    }

    @Secured("VENDEDOR")
    @GetMapping("/vendedor")
    public String onlyvendedor(Authentication authentication) {
        return "vendedor: " + authentication.getName();
    }


    @GetMapping("/cliente")
    public String onlycliente(Authentication authentication) {
        return "cliente: " + authentication.getName();
    }
}
