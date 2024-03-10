package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:49 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public Long saveTransaction(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public TransactionDTO getTransaction(long id) {
        return null;
    }

    @Override
    public boolean updateTransaction(TransactionDTO transactionDTO) {
        return false;
    }

    @Override
    public boolean deleteTransaction(TransactionDTO transactionDTO) {
        return false;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return null;
    }
}
