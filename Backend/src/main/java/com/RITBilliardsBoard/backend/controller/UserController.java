package com.RITBilliardsBoard.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class that contains endpoints for user
 * When using any endpoint in this class you must include a valid JWT Token
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    /**
     * Demo Endpoint
     * To use this endpoint register a valid user and copy the Token (No quotes).
     * Then follow this format in the http request:
     *      GET http://localhost:8082/api/user/HelloWorld
     *      Authorization: Bearer <Token>
     */
    @GetMapping("/HelloWorld")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}