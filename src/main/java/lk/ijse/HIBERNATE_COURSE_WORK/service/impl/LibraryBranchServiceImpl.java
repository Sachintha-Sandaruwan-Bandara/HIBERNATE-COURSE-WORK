package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:48 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.LibraryBranchRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.LibraryBranchRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.LibraryBranchService;
import org.hibernate.Session;

import java.util.List;

public class LibraryBranchServiceImpl implements LibraryBranchService {
    private Session session;

    private static LibraryBranchService libraryBranchService;

    private final LibraryBranchRepository libraryBranchRepository;

    private LibraryBranchServiceImpl(){
        libraryBranchRepository=LibraryBranchRepositoryImpl.getInstance();
    }

    public static LibraryBranchService getInstance(){
        return null==libraryBranchService
                ?libraryBranchService=new LibraryBranchServiceImpl()
                :libraryBranchService;
    }

    @Override
    public Long saveLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        return null;
    }

    @Override
    public LibraryBranchDTO getLibraryBranch(long id) {
        return null;
    }

    @Override
    public boolean updateLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        return false;
    }

    @Override
    public boolean deleteLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        return false;
    }

    @Override
    public List<LibraryBranchDTO> getAllLibraryBranches() {
        return null;
    }
}
