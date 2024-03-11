package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:49 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.UserRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.UserRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import org.hibernate.Session;

import java.util.List;

public class UserServiceImpl implements UserService {
    private Session session;
    private static UserService userService;

    private final UserRepository userRepository;

    private UserServiceImpl(){
        userRepository=UserRepositoryImpl.getInstance();
    }
    public static UserService getInstance(){
        return null==userService
                ?userService=new UserServiceImpl()
                :userService;
    }
    @Override
    public Long saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUser(long id) {
        return null;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }
}
