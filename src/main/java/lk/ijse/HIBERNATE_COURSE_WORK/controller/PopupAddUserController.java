package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/15/2024 - 11:19 AM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

public class PopupAddUserController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    private long adminId;

    private UserService userService;
    private AdminService adminService;


    public void initialize(){
        adminId=LoginPageController.adminId;
        userService= UserServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(txtUserName.getText());
        userDTO.setPassword(txtPassword.getText());
        userDTO.setEmail(txtEmail.getText());

        AdminDTO admin = adminService.getAdmin(adminId);
        userDTO.setAdmin(admin);

        Long userId= userService.saveUser(userDTO);

        System.out.println("user saved ID:"+userId);


    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) txtUserName.getScene().getWindow();
        stage.close();
    }
}
