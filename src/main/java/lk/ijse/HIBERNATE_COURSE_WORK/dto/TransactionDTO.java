package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:30 PM 
*/




import lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDTO {
    private Long id;

    private Date returnDate;
    private Date borrowDate;
    private Date dueDate;
    private int qty;
    private UserDTO user;
    private BookDTO book;

    public Transaction toEntity(){
        Transaction transaction = new Transaction();
        transaction.setId(this.id);
        transaction.setReturnDate(this.returnDate);
        transaction.setBorrowDate(this.borrowDate);
        transaction.setDueDate(this.dueDate);
        transaction.setQty(this.qty);
        if (this.user!=null) {
            transaction.setUser(this.user.toEntity());
        }
        if (this.book!=null) {
            transaction.setBook(this.book.toEntity());
        }
        return transaction;
    }
}
