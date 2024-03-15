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
import javafx.scene.layout.AnchorPane;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminAuthDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserAuthDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Navigation;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Routes;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

import java.io.IOException;

public class LoginPageController {
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    public static long adminId;
    public static long userId;




    private AdminService adminService = AdminServiceImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();

    public void initialize() {
        // Initialization code here
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        // Validate username and password using regex
        if (!username.matches("^[a-zA-Z]{3,20}$")) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid username format. Please enter a valid username (3-20 alphabetic characters).");
            return;
        }

        if (!password.matches("^[0-9]{4}$")) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid password format. Please enter a valid password (4 digits).");
            return;
        }

        UserAuthDTO userAuthDTO = userService.authenticate(username, password);
        AdminAuthDTO adminAuthDTO = adminService.authenticate(username, password);

        if (userAuthDTO.isFlag()) {
            System.out.println("User logged in");
            userId = userAuthDTO.getId();
            Navigation.navigate(Routes.USERLOGIN, anchorpane);
        } else {
            System.out.println("This is not a user");
        }

        if (adminAuthDTO.isFlag()) {
            System.out.println("Admin logged in");
            adminId = adminAuthDTO.getId();
            Navigation.navigate(Routes.ADMINLOGIN, anchorpane);
        } else {
            System.out.println("This is not an admin");
        }
    }

    @FXML
    void createAccountOnMouseClicked(MouseEvent event) throws IOException {
        // Implement create account action

        Navigation.navigate(Routes.CREATEACCOUNT,anchorpane);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
