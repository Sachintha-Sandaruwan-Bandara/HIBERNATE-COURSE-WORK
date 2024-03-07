package lk.ijse.HIBERNATE_COURSE_WORK.entity;
/* 
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:31 PM 
*/

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date returnDate;
    private Date borrowDate;
    private Date dueDate;
    private int qty;



    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public Transaction() {
    }

    public Transaction(Long id, Date returnDate, Date borrowDate, Date dueDate, int qty, User user, Book book) {
        this.id = id;
        this.returnDate = returnDate;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.qty = qty;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", returnDate=" + returnDate +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", qty=" + qty +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}