package lk.ijse.HIBERNATE_COURSE_WORK.service;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:46 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;

import java.util.List;

public interface TransactionService extends SuperService{
    Long saveTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransaction(long id);

    boolean updateTransaction(TransactionDTO transactionDTO);

    boolean deleteTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> getAllTransactions();
}
