package com.example.ktcrud.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String brithDay;
    private boolean isDelete;
}
