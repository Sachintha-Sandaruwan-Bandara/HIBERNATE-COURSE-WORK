package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:05 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.LibraryBranchRepository;
import org.hibernate.Session;

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
    public Long save(LibraryBranch object) {
        return null;
    }

    @Override
    public void update(LibraryBranch object) {

    }

    @Override
    public LibraryBranch get(Long aLong) {
        return null;
    }

    @Override
    public void delete(LibraryBranch object) {

    }

    @Override
    public List<LibraryBranch> getAll() {
        return null;
    }
}
