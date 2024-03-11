package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:35 PM 
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "libraryBranch")
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "libraryBranch")
    private List<Book> books;

    @ManyToOne
    private Admin admin;

    public LibraryBranchDTO toDTO(){
        LibraryBranchDTO libraryBranchDTO = new LibraryBranchDTO();

        return libraryBranchDTO;
    }
}

