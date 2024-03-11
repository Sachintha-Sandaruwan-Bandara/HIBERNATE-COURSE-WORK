package lk.ijse.HIBERNATE_COURSE_WORK.entity;
/* 
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:31 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

    public TransactionDTO toDTO(){
        TransactionDTO transactionDTO = new TransactionDTO();

        return transactionDTO;
    }

}