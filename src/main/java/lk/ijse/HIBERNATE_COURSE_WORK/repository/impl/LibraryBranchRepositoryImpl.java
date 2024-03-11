package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:05 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.LibraryBranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibraryBranchRepositoryImpl implements LibraryBranchRepository {
private Session session;
private static LibraryBranchRepositoryImpl libraryBranchRepositoryImpl;
private LibraryBranchRepositoryImpl(){}

public static LibraryBranchRepositoryImpl getInstance(){
    return null==libraryBranchRepositoryImpl
            ?libraryBranchRepositoryImpl=new LibraryBranchRepositoryImpl()
            :libraryBranchRepositoryImpl;

}
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Long save(LibraryBranch object) {
        return (Long) session.save(object);
    }

    @Override
    public void update(LibraryBranch object) {
        session.update(object);
    }

    @Override
    public LibraryBranch get(Long aLong) {
        return session.get(LibraryBranch.class, aLong);
    }

    @Override
    public void delete(LibraryBranch object) {
        session.delete(object);
    }

    @Override
    public List<LibraryBranch> getAll() {
        String sqlQuery = "FROM LibraryBranch ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;
    }


}
