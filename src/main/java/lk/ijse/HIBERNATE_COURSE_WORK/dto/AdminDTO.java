package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:21 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.Book;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private Long id;
    private String username;
    private String password;
    private List<BookDTO> books;
    private List<LibraryBranchDTO> libraryBranches;
    private List<UserDTO> users;

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(this.getId());
        admin.setUsername(this.getUsername());
        admin.setPassword(this.getPassword());

//        dto lists convert to entity lists
        if (this.books !=null) {
            List<Book> bookList = new ArrayList<>();
            for (BookDTO bookDTO : books) {
                bookList.add(bookDTO.toEntity());
            }
            admin.setBooks(bookList);
        }

        if (this.libraryBranches !=null) {
            List<LibraryBranch> libraryBranchList = new ArrayList<>();

            for (LibraryBranchDTO libraryBranchDTO : this.libraryBranches) {
                libraryBranchList.add(libraryBranchDTO.toEntity());
            }

            admin.setLibraryBranches(libraryBranchList);
        }
        if (this.users!=null) {
            List<User> userList = new ArrayList<>();

            for (UserDTO userDto : users) {
                userList.add(userDto.toEntity());
            }

            admin.setUsers(userList);
        }
        return admin;
    }

}
