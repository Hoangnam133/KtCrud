package com.example.ktcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false)
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private Date brithDay;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
