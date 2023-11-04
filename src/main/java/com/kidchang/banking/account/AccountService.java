package com.kidchang.banking.account;

import com.kidchang.banking.account.dto.AccountDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<AccountDto> getAccounts(Integer userId) {
        return AccountDto.accountListResponse(accountRepository.findByOwnerId(userId));
    }
}
