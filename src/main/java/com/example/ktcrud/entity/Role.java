package com.example.ktcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adding this line
    private int role_id;
    @Column(unique = true, nullable = false)
    private String role_name;
    @OneToMany(mappedBy = "role")
    List<User> users;
}
