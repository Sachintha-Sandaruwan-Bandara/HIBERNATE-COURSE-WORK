package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:21 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO{
    private Long id;

    private String title;
    private String author;
    private String gener;
    private int qty;
    private Admin admin;
    private LibraryBranchDTO libraryBranch;
    private List<TransactionDTO> transactions;
}
