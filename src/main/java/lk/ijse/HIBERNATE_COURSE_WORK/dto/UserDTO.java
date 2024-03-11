package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:30 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<TransactionDTO> transactions;
    private AdminDTO admin;
public User toEntity(){
    User user = new User();
    user.setId(this.id);
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setEmail(this.email);
    return user;
}


}
