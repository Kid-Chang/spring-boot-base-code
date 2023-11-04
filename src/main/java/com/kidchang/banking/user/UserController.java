package com.kidchang.banking.user;

import com.kidchang.banking._base.dto.DataResponseDto;
import com.kidchang.banking.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public DataResponseDto<Object> getUsers() {
        return DataResponseDto.of(userService.getUsers());
    }

    @PostMapping("")
    public DataResponseDto<Object> createUser(@RequestBody UserDto userDto) {
        return DataResponseDto.of(userService.saveUser(userDto));
    }

}
