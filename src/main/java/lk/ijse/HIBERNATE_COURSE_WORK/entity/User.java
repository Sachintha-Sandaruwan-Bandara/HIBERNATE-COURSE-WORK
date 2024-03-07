package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import javax.persistence.*;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:28 PM 
*/
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @ManyToOne
    private Admin admin;

    public User() {
    }

    public User(Long id, String username, String password, String email, List<Transaction> transactions, Admin admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.transactions = transactions;
        this.admin = admin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", transactions=" + transactions +
                ", admin=" + admin +
                '}';
    }
}
