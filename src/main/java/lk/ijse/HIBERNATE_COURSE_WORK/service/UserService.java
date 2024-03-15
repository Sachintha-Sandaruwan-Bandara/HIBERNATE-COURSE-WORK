package lk.ijse.HIBERNATE_COURSE_WORK.service;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:50 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserAuthDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;

import java.util.List;

public interface UserService extends SuperService{
    Long saveUser(UserDTO userDTO);

    UserDTO getUser(long id);

    boolean updateUser(UserDTO userDTO);

    boolean deleteUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
    UserAuthDTO authenticate(String username, String password);

    List<UserDTO>getOverDueUsers();
}
