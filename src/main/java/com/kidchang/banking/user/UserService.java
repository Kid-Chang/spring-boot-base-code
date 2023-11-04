package com.kidchang.banking.user;

import com.kidchang.banking.user.dto.UserDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // 원래는 이럴때 jwt 리턴
    public Object saveUser(UserDto userDto) {

        // validation check 필요

        userDto.setGrade("일반");
        userDto.setStatus("ACTIVE");
        userRepository.save(userDto.toEntity());
        return userDto;
    }
}
