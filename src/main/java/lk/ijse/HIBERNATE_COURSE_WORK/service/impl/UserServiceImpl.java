package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:49 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserAuthDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.UserRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.UserRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Session session;
    private static UserService userService;

    private final UserRepository userRepository;
    private List<UserDTO>userDTOList;

    private UserServiceImpl(){
        userRepository=UserRepositoryImpl.getInstance();
        userDTOList=getAllUsers();
    }
    public static UserService getInstance(){
        return (null==userService)
                ?userService=new UserServiceImpl()
                :userService;
    }
    @Override
    public Long saveUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
           userRepository.setSession(session);
            Long id = userRepository.save(userDTO.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public UserDTO getUser(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            userRepository.setSession(session);
            User user = userRepository.get(id);
            session.close();
            return user.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.delete(userDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        userRepository.setSession(session);
        List<User> allUsers= userRepository.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : allUsers) {
            userDTOList.add(user.toDTO());
        }
        return userDTOList;
    }

    @Override
    public UserAuthDTO authenticate(String username, String password) {
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        for (UserDTO user : userDTOList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                Long id = user.getId();

                userAuthDTO.setFlag(true);
                userAuthDTO.setId(id);
                return userAuthDTO;
            }
        }
        return userAuthDTO;
    }

}
