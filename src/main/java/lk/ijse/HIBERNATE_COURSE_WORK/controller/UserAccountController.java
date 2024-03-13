package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 1:34 PM 
*/
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

public class UserAccountController {

    @FXML
    private JFXToggleButton togleBtnUpdate;
    @FXML
    private Label lblNewPwd;

    @FXML
    private Label lblRePwd;
    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblUserName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtReEnterPassword;

    @FXML
    private TextField txtUserName;

    private long userId;

    private UserService userService;

    private UserDTO exsistingUser;

    public void initialize(){
        visibleFalse();
        this.userId=LoginPageController.userId;
        userService=UserServiceImpl.getInstance();
        loadUser();
    }

    private void loadUser() {
        exsistingUser = userService.getUser(userId);
       lblUserName.setText(exsistingUser.getUsername());
       lblEmail.setText(exsistingUser.getEmail());
       txtUserName.setText(exsistingUser.getUsername());
       txtEmail.setText(exsistingUser.getEmail());
    }

    private void visibleFalse() {
        txtUserName.setVisible(false);
        txtEmail.setVisible(false);
        txtPassword.setVisible(false);
        txtReEnterPassword.setVisible(false);
        lblNewPwd.setVisible(false);
        lblRePwd.setVisible(false);
        btnUpdate.setVisible(false);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userId);
        userDTO.setUsername(txtUserName.getText());
        userDTO.setEmail(txtEmail.getText());
        if (txtPassword.getText().equals(txtReEnterPassword.getText())) {
            userDTO.setPassword(txtPassword.getText());

        }else {
            System.out.println("new pwd and re enterd passwords are not same");
            userDTO.setPassword(exsistingUser.getPassword());
        }

        boolean b = userService.updateUser(userDTO);

        if (b){
            System.out.println("update successful");
        }


    }

    @FXML
    void toggleBtnUpdateOnAction(ActionEvent event) {
        if (togleBtnUpdate.isSelected()) {
            visibleTrue();

        } else {
           visibleFalse();
        }
    }

    private void visibleTrue() {
        txtUserName.setVisible(true);
        txtEmail.setVisible(true);
        txtPassword.setVisible(true);
        txtReEnterPassword.setVisible(true);
        lblNewPwd.setVisible(true);
        lblRePwd.setVisible(true);
        btnUpdate.setVisible(true);
    }
}
