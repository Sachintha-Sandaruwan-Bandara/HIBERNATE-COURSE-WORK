package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 12:00 PM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Navigation;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Routes;

import java.io.IOException;

public class UserDashboardController {
    @FXML
    private AnchorPane anchorPaneReloading;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.USERBOOKS,anchorPaneReloading);

    }

    @FXML
    void btnBorrowdBooksOnAction(ActionEvent event) throws IOException {
Navigation.navigate(Routes.USERBORROWDBOOKS,anchorPaneReloading);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {


    }

    @FXML
    void btnMyAccountOnAction(ActionEvent event) throws IOException {
Navigation.navigate(Routes.USERACCOUNT,anchorPaneReloading);
    }

    @FXML
    void btnMyCartOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.USERCART,anchorPaneReloading);
    }

}
