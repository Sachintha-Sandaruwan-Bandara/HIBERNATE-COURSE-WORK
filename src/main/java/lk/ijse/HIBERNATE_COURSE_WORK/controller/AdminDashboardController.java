package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 12:01 PM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Navigation;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Routes;

import java.io.IOException;

public class AdminDashboardController {
    @FXML
    private AnchorPane anchorPaneReloading;

    @FXML
    private AnchorPane mainAp;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMINBOOKS,anchorPaneReloading);
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMINBRANCHES,anchorPaneReloading);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGOUT,mainAp);
    }

    @FXML
    void btnMyAccountOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMINACCOUNT,anchorPaneReloading);
    }

    @FXML
    void btnOverdueUsersOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMINOVERDUEUSERS,anchorPaneReloading);
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMINUSERS,anchorPaneReloading);
    }
}
