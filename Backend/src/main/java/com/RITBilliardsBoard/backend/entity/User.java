package com.RITBilliardsBoard.backend.entity;

import com.RITBilliardsBoard.backend.auth.entity.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @ToString.Exclude
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}