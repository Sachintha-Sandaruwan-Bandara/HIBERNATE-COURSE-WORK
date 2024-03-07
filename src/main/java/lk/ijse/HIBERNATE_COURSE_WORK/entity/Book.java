package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:33 PM 
*/
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String gener;

    private int qty;


    @ManyToOne
    private Admin admin;

    @ManyToOne
    private LibraryBranch libraryBranch;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;

    public Book() {
    }

    public Book(Long id, String title, String author, String gener, int qty, Admin admin, LibraryBranch libraryBranch, List<Transaction> transactions) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.gener = gener;
        this.qty = qty;
        this.admin = admin;
        this.libraryBranch = libraryBranch;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LibraryBranch getLibraryBranch() {
        return libraryBranch;
    }

    public void setLibraryBranch(LibraryBranch libraryBranch) {
        this.libraryBranch = libraryBranch;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", gener='" + gener + '\'' +
                ", qty=" + qty +
                ", admin=" + admin +
                ", libraryBranch=" + libraryBranch +
                ", transactions=" + transactions +
                '}';
    }
}