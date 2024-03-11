package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:30 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Transaction;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;

    private AdminDTO admin;
    private List<TransactionDTO> transactions;

public User toEntity(){
    User user = new User();
    user.setId(this.id);
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setEmail(this.email);
    user.setAdmin(this.admin.toEntity());
    List<Transaction>transactionList=new ArrayList<>();
    for (TransactionDTO transactionDto:transactions) {
        transactionList.add(transactionDto.toEntity());
    }
    user.setTransactions(transactionList);
    return user;
}


}
