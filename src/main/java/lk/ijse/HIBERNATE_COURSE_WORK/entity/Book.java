package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:33 PM 
*/

@AllArgsConstructor
@NoArgsConstructor
@Data
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

    public BookDTO toDTO() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(this.id);
        bookDTO.setTitle(this.title);
        bookDTO.setAuthor(this.author);
        bookDTO.setGener(this.gener);
        bookDTO.setQty(this.qty);
//        if (this.admin!=null) {
//            bookDTO.setAdmin(this.admin.toDTO());
//        }
//        if (this.transactions!=null) {
//            bookDTO.setLibraryBranch(this.libraryBranch.toDTO());
//            List<TransactionDTO> transactionDTOS = new ArrayList<>();
//            for (Transaction transaction : transactions) {
//                transactionDTOS.add(transaction.toDTO());
//            }
//            bookDTO.setTransactions(transactionDTOS);
//        }
        return bookDTO;
    }

}