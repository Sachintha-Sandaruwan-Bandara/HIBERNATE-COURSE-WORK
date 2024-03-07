package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:28 PM 
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
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


}
