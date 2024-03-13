package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/5/2024 - 8:48 PM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

public class LoginPageController{
        @FXML
        private TextField txtPassword;

        @FXML
        private TextField txtUserName;

        private AdminService adminService = AdminServiceImpl.getInstance();
        private UserService userService = UserServiceImpl.getInstance();

        public void initialize() {
            // Initialization code here
        }

        @FXML
        void btnLoginOnAction(ActionEvent event) {
            String username = txtUserName.getText();
            String password = txtPassword.getText();


                boolean userRole = userService.authenticate(username, password);
                boolean adminRole = adminService.authenticate(username, password);

                System.out.println(userRole);
                System.out.println(adminRole);

                if (userRole) {
                    System.out.println("User logged in");

                }else{
                    System.out.println("this is not user");
                }

                if (adminRole) {
                    System.out.println("Admin logged in");

                } else{
                    System.out.println("this is not admin");
                }

        }

        @FXML
        void createAccountOnMouseClicked(MouseEvent event) {
            // Implement create account action
        }

        private void showAlert(Alert.AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
}
