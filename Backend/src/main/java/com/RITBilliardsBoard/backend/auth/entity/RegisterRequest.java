package com.RITBilliardsBoard.backend.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * Request someone fills out to sign up
 * TODO: Fit to meet User Class
 */
public class RegisterRequest {

    private String name;

    private String email;

    private String password;
}
