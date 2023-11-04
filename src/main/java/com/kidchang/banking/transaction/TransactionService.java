package com.kidchang.banking.transaction;

import com.kidchang.banking._base.constant.Code;
import com.kidchang.banking._base.exception.GeneralException;
import com.kidchang.banking.transaction.dto.TransactionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionDto getTransaction(Integer transactionId) {
        return TransactionDto.transactionResponse(
            transactionRepository.findById(transactionId).orElseThrow(
                () -> new GeneralException(Code.TRANSACTION_NOT_FOUND)
            ));
    }

    public List<TransactionDto> getTransactions(String accountId) {
        List<TransactionDto> transactionDtoList = TransactionDto.transactionListResponse(
            transactionRepository.findByAccountNumber(accountId));

        if (transactionDtoList.size() == 0) {
            throw new GeneralException(Code.ACCOUNT_TRANSACTION_NOT_FOUND);
        }

        return transactionDtoList;
    }
}
