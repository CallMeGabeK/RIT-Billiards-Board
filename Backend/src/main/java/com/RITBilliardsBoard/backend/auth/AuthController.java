package com.RITBilliardsBoard.backend.auth;

import com.RITBilliardsBoard.backend.auth.entity.AuthRequest;
import com.RITBilliardsBoard.backend.auth.entity.AuthResponse;
import com.RITBilliardsBoard.backend.auth.service.AuthService;
import com.RITBilliardsBoard.backend.auth.entity.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
