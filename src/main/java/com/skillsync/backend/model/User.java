package com.skillsync.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Lombok: creates getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users") // optional: specify table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
