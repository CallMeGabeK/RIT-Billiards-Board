package com.RITBilliardsBoard.backend.auth.service;

import com.RITBilliardsBoard.backend.auth.UserRepository;
import com.RITBilliardsBoard.backend.auth.entity.AuthRequest;
import com.RITBilliardsBoard.backend.auth.entity.AuthResponse;
import com.RITBilliardsBoard.backend.auth.entity.Role;
import com.RITBilliardsBoard.backend.auth.entity.RegisterRequest;
import com.RITBilliardsBoard.backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    //TODO: Fit to meet User Class
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        repository.save(user);

        var jwtToken = jwtService.generateToken(request.getEmail());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(request.getEmail());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
