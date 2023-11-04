package com.kidchang.banking.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kidchang.banking.user.User;
import com.kidchang.banking.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Integer id;
    private String password;
    private String name;
    private String grade;
    private Integer age;
    private String email;
    private String phone;
    private String status;


    private UserRepository userRepository;

    public UserDto() {
    }

    public User toEntity() {
        return User.builder()
            .id(id)
            .password(password)
            .name(name)
            .age(age)
            .email(email)
            .phone(phone)
            .status(status)
            .grade(grade)
            .status(status)
            .build();
    }
}
