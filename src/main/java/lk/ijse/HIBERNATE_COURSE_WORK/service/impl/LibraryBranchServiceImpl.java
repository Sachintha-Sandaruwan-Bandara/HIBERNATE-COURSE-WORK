package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:48 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.LibraryBranchRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.LibraryBranchRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.LibraryBranchService;
import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
           libraryBranchRepository.setSession(session);
            Long id = libraryBranchRepository.save(libraryBranchDTO.toEntity());
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
    public LibraryBranchDTO getLibraryBranch(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            libraryBranchRepository.setSession(session);
            LibraryBranch libraryBranch = libraryBranchRepository.get(id);
            session.close();
            return libraryBranch.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            libraryBranchRepository.setSession(session);
            libraryBranchRepository.update(libraryBranchDTO.toEntity());
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
    public boolean deleteLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            libraryBranchRepository.setSession(session);
           libraryBranchRepository.delete(libraryBranchDTO.toEntity());
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
    public List<LibraryBranchDTO> getAllLibraryBranches() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        libraryBranchRepository.setSession(session);
        List<LibraryBranch>allLibraryBranches = libraryBranchRepository.getAll();
        List<LibraryBranchDTO> libraryBranchDTOList = new ArrayList<>();
        for (LibraryBranch libraryBranch : allLibraryBranches) {
            libraryBranchDTOList.add(libraryBranch.toDTO());
        }
        return libraryBranchDTOList;
    }

}
