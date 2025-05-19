package com.example.watchapp.User.dto;

import com.example.watchapp.User.domain.Gender;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String dni;
    private String name;
    private String email;
    private int age;
    private Gender gender;
    private String phone;
}
