package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:21 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.Book;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private Long id;

    private String title;
    private String author;
    private String gener;
    private int qty;
    private Admin admin;
    private LibraryBranchDTO libraryBranch;
    private List<TransactionDTO> transactions;

    public Book toEntity() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setGener(this.gener);
        book.setQty(this.qty);
        book.setAdmin(this.admin);
        book.setLibraryBranch(this.libraryBranch.toEntity());
        List<Transaction>transactionList=new ArrayList<>();
        for (TransactionDTO transactionDto:this.transactions) {
            transactionList.add(transactionDto.toEntity());
        }
        book.setTransactions(transactionList);
        return book;


    }


}
