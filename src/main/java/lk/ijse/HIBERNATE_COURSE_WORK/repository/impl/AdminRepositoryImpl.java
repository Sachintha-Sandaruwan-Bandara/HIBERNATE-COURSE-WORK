package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:04 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.AdminRepository;
import org.hibernate.Session;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

private Session session;
private static AdminRepositoryImpl adminRepositoryImpl;

private AdminRepositoryImpl(){

}
public static AdminRepositoryImpl getInstance(){
    return null==adminRepositoryImpl
            ?adminRepositoryImpl=new AdminRepositoryImpl()
            :adminRepositoryImpl;
}

    @Override
    public Long save(Admin object) {
        return null;
    }

    @Override
    public void update(Admin object) {

    }

    @Override
    public Admin get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Admin object) {

    }

    @Override
    public List<Admin> getAll() {
        return null;
    }
}
