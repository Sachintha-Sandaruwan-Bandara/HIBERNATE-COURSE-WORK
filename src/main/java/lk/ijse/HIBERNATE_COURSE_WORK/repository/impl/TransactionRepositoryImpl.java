package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:06 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.TransactionRepository;
import org.hibernate.Session;

import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
private Session session;
private static TransactionRepositoryImpl transactionRepositoryImpl;
private TransactionRepositoryImpl(){}

    public static TransactionRepositoryImpl getInstance(){
    return null==transactionRepositoryImpl
            ?transactionRepositoryImpl=new TransactionRepositoryImpl()
            :transactionRepositoryImpl;
    }
    @Override
    public Long save(Transaction object) {
        return null;
    }

    @Override
    public void update(Transaction object) {

    }

    @Override
    public Transaction get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Transaction object) {

    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }
}
