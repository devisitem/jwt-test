package me.kimchi.JwtTest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloController {

    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/encode")
    public ResponseEntity<String> getEncodePassword(@RequestParam String password){

        String encoded = passwordEncoder.encode(password);

        return ResponseEntity.ok(encoded);
    }
}
