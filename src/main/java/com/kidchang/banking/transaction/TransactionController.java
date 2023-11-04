package com.kidchang.banking.transaction;

import com.kidchang.banking._base.dto.DataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("{transactionId}")
    public DataResponseDto<Object> getTransaction(
        @PathVariable("transactionId") Integer transactionId) {
        return DataResponseDto.of(transactionService.getTransaction(transactionId));
    }

    @GetMapping("")
    public DataResponseDto<Object> getTransactions(
        @RequestParam String accountId) {
        return DataResponseDto.of(transactionService.getTransactions(accountId));

    }
}
