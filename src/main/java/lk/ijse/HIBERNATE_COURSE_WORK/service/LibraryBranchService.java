package lk.ijse.HIBERNATE_COURSE_WORK.service;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:46 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;

import java.util.List;

public interface LibraryBranchService extends SuperService{
    Long saveLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    LibraryBranchDTO getLibraryBranch(long id);

    boolean updateLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    boolean deleteLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    List<LibraryBranchDTO> getAllLibraryBranches();
}
