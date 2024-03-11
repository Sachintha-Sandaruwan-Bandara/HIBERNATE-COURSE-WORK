package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:05 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public void setSession(Session session) {
        this.session = session;
    }
    @Override
    public Long save(User object) {
        return (Long) session.save(object);
    }

    @Override
    public void update(User object) {
        session.update(object);
    }

    @Override
    public User get(Long aLong) {
        return session.get(User.class, aLong);
    }

    @Override
    public void delete(User object) {
        session.delete(object);

    }

    @Override
    public List<User> getAll(){
        String sqlQuery = "FROM User ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;
    }


}

