package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:49 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.TransactionRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.TransactionRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.TransactionService;
import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private Session session;
    private static TransactionService transactionService;

    private final TransactionRepository transactionRepository;

    private TransactionServiceImpl(){
        transactionRepository=TransactionRepositoryImpl.getInstance();
    }
    public static TransactionService getInstance(){
        return (null==transactionService)
                ?transactionService=new TransactionServiceImpl()
                :transactionService;
    }
    @Override
    public Long saveTransaction(TransactionDTO transactionDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            Long id = transactionRepository.save(transactionDTO.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public TransactionDTO getTransaction(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            transactionRepository.setSession(session);
            lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction transaction = transactionRepository.get(id);
            session.close();
            return transaction.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateTransaction(TransactionDTO transactionDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
           transactionRepository.update(transactionDTO.toEntity());
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTransaction(TransactionDTO transactionDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            transactionRepository.delete(transactionDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        transactionRepository.setSession(session);
        List<lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction> allTransactions= transactionRepository.getAll();
        List<TransactionDTO> transactionDTOList = new ArrayList<>();
        for (lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction transaction: allTransactions) {
            transactionDTOList.add(transaction.toDTO());
        }
        return transactionDTOList;
    }

}
