package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:21 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        // You can add mapping for other properties here
        return admin;
    }

}
