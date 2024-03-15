package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/7/2024 - 5:19 PM 
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String email;


    @OneToMany(mappedBy = "admin")
    private List<Book> books;

    @OneToMany(mappedBy = "admin")
    private List<LibraryBranch> libraryBranches;

    @OneToMany(mappedBy = "admin")
    private List<User> users;

    public AdminDTO toDTO(){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(this.id);
        adminDTO.setUsername(this.username);
        adminDTO.setPassword(this.password);
        adminDTO.setEmail(this.email);
//        if (this.books!=null) {
//            List<BookDTO> bookDTOS = new ArrayList<>();
//            for (Book book : this.books) {
//                bookDTOS.add(book.toDTO());
//            }
//            adminDTO.setBooks(bookDTOS);
//        }
//        if (this.libraryBranches!=null) {
//            List<LibraryBranchDTO> libraryBranchDTOS = new ArrayList<>();
//            for (LibraryBranch libraryBranch : this.libraryBranches) {
//                libraryBranchDTOS.add(libraryBranch.toDTO());
//            }
//            adminDTO.setLibraryBranches(libraryBranchDTOS);
//
//        }
//        if (this.users!=null) {
//            List<UserDTO> userDTOS = new ArrayList<>();
//            for (User user : this.users) {
//                userDTOS.add(user.toDTO());
//            }
//            adminDTO.setUsers(userDTOS);
//        }
        return adminDTO;
    }

}
