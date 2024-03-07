package lk.ijse.HIBERNATE_COURSE_WORK.entity;

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

}