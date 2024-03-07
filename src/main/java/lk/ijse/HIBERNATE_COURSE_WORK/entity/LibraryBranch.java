package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import javax.persistence.*;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:35 PM 
*/
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

    public LibraryBranch() {
    }

    public LibraryBranch(Long id, String name, String location, List<Book> books, Admin admin) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.books = books;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "LibraryBranch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", books=" + books +
                ", admin=" + admin +
                '}';
    }
}

