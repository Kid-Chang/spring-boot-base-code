package com.kidchang.banking.transaction.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kidchang.banking.transaction.Transaction;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {

    private Integer id;
    private Integer transAmount;
    private String type;
    private Integer balanceAfterTransaction;
    private String accountNumber;
    private String transTargetAccountNumber;
    private String result;

    public static List<TransactionDto> transactionListResponse(
        List<Transaction> transactionDtoList) {
        return transactionDtoList.stream().map(TransactionDto::transactionResponse).toList();
    }

    public static TransactionDto transactionResponse(Transaction transaction) {
        return TransactionDto.builder()
            .id(transaction.getId())
            .transAmount(transaction.getTransAmount())
            .type(transaction.getType())
            .balanceAfterTransaction(transaction.getBalanceAfterTransaction())
            .accountNumber(transaction.getAccountNumber())
            .transTargetAccountNumber(builder().transTargetAccountNumber)
            .result(transaction.getResult())
            .build();
    }
}
