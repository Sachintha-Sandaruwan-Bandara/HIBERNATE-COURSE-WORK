package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 6:03 PM 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;

import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;


public class AdminAccountController {

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

    private long adminId;

    private AdminService adminService;

    private AdminDTO exsistingAdmin;

    public void initialize(){
        visibleFalse();
        this.adminId=LoginPageController.adminId;
        adminService= AdminServiceImpl.getInstance();
        loadUser();
    }

    private void loadUser() {
        exsistingAdmin = adminService.getAdmin(adminId);
        lblUserName.setText(exsistingAdmin.getUsername());
        lblEmail.setText(exsistingAdmin.getEmail());
        txtUserName.setText(exsistingAdmin.getUsername());
        txtEmail.setText(exsistingAdmin.getEmail());
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
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(adminId);
        adminDTO.setUsername(txtUserName.getText());
        adminDTO.setEmail(txtEmail.getText());
        if (txtPassword.getText().equals(txtReEnterPassword.getText())) {
            adminDTO.setPassword(txtPassword.getText());

        }else {
            System.out.println("new pwd and re enterd passwords are not same");
            adminDTO.setPassword(exsistingAdmin.getPassword());
        }

        boolean b = adminService.updateAdmin(adminDTO);

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
