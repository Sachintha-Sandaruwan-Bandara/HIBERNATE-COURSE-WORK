package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bridj.cpp.mfc.CString;

import javax.persistence.*;
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


    @OneToMany(mappedBy = "admin")
    private List<Book> books;

    @OneToMany(mappedBy = "admin")
    private List<LibraryBranch> libraryBranches;

    @OneToMany(mappedBy = "admin")
    private List<User> users;

}
