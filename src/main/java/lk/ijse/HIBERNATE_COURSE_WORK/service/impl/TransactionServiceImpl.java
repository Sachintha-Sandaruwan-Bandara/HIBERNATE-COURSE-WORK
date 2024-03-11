package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:49 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.TransactionRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.TransactionRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.TransactionService;
import org.hibernate.Session;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private Session session;
    private static TransactionService transactionService;

    private final TransactionRepository transactionRepository;

    private TransactionServiceImpl(){
        transactionRepository=TransactionRepositoryImpl.getInstance();
    }
    public static TransactionService getInstance(){
        return null==transactionService
                ?transactionService=new TransactionServiceImpl()
                :transactionService;
    }
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
