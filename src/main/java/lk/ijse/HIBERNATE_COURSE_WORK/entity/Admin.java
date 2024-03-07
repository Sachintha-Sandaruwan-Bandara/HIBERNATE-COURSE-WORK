package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import org.bridj.cpp.mfc.CString;

import javax.persistence.*;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/7/2024 - 5:19 PM 
*/
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

    public Admin() {
    }

    public Admin(Long id, String username, String password, List<Book> books, List<LibraryBranch> libraryBranches, List<User> users) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.books = books;
        this.libraryBranches = libraryBranches;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<LibraryBranch> getLibraryBranches() {
        return libraryBranches;
    }

    public void setLibraryBranches(List<LibraryBranch> libraryBranches) {
        this.libraryBranches = libraryBranches;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", books=" + books +
                ", libraryBranches=" + libraryBranches +
                ", users=" + users +
                '}';
    }
}
