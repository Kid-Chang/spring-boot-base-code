package com.kidchang.banking.account;

import com.kidchang.banking._base.dto.DataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("")
    public DataResponseDto<Object> getAccounts(@RequestParam Integer userId) {
        return DataResponseDto.of(accountService.getAccounts(userId));
    }

    //  @GetMapping("{userId}")


}
