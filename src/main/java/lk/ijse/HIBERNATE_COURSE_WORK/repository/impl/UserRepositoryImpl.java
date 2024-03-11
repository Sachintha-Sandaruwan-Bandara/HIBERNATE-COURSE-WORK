package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:05 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.UserRepository;
import org.hibernate.Session;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Session session;
    private static UserRepositoryImpl userRepositoryImpl;

    private UserRepositoryImpl(){}

    public static UserRepositoryImpl getInstance(){
        return null==userRepositoryImpl
                ?userRepositoryImpl=new UserRepositoryImpl()
                :userRepositoryImpl;
    }

    @Override
    public Long save(User object) {
        return null;
    }

    @Override
    public void update(User object) {

    }

    @Override
    public User get(Long aLong) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}

