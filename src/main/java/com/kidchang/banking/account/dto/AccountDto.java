package com.kidchang.banking.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kidchang.banking.account.Account;
import com.kidchang.banking.user.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {

    private String accountNumber;
    private Integer balance;
    private String type;
    private String accountAlias;
    private String password;
    private String status;
    private User user;

    public static List<AccountDto> accountListResponse(List<Account> accountDtoList) {
        return accountDtoList.stream().map(AccountDto::accountResponse).toList();
    }

    public static AccountDto accountResponse(Account account) {
        return AccountDto.builder()
            .accountNumber(account.getAccountNumber())
            .balance(account.getBalance())
            .type(account.getType())
            .accountAlias(account.getAccountAlias())
            .password(account.getPassword())
            .status(account.getStatus())
            .build();
    }
}
