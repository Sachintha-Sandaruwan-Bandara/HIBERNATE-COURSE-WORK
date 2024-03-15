package lk.ijse.HIBERNATE_COURSE_WORK.navigation;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 12:04 PM 
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    public static AnchorPane anchorPane;


    public static void navigate(Routes route, javafx.scene.layout.AnchorPane anchorPane) throws IOException {
        Navigation.anchorPane = anchorPane;
        Navigation.anchorPane.getChildren().clear();
        Stage window = (Stage) Navigation.anchorPane.getScene().getWindow();


        switch (route) {
            case LOGOUT:
                initUI("loginPage.fxml");
                window.setTitle("login Page");
                break;
            case USERLOGIN:
                initUI("userDashboard.fxml");
                window.setTitle("user dashboard");
                break;
            case ADMINLOGIN:
                initUI("adminDashboard.fxml");
                window.setTitle("admin dashboard");
                break;
            case USERBOOKS:
                initUI("userBooks.fxml");
                window.setTitle("books");
                break;

            case USERBORROWDBOOKS:
                initUI("userBorrowdBooks.fxml");
                window.setTitle("borrowd books");
                break;
            case USERACCOUNT:
                initUI("userAccount.fxml");
                window.setTitle("user account");
                break;
            case ADMINBOOKS:
                initUI("adminBooks.fxml");
                window.setTitle("books");
                break;
            case ADMINUSERS:
                initUI("adminUsers.fxml");
                window.setTitle("users");
                break;
            case ADMINOVERDUEUSERS:
                initUI("adminOverdueUsers.fxml");
                window.setTitle("overdue users");
                break;
            case ADMINBRANCHES:
                initUI("adminBranches.fxml");
                window.setTitle("branches");
                break;
            case ADMINACCOUNT:
                initUI("adminAccount.fxml");
                window.setTitle("admin account");
                break;
            case CREATEACCOUNT:
                initUI("adminCreateAccount.fxml");
                window.setTitle("admin create account");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.anchorPane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/view/" + location)));
    }


    public static void navigatePopUpWindow(Routes route) throws IOException {
        switch (route) {
            case ADDUSER:
                initPopUp("popUpAddUser");
                break;
            case ADDBOOK:
                initPopUp("popUpAddBook");
                break;
            case ADDBRANCH:
                initPopUp("popUpAddBranch");
                break;


        }


    }

    private static void initPopUp(String url) throws IOException {

        Parent root = FXMLLoader.load(Navigation.class.getResource("/view/" + url + ".fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);

        stage.setTitle("");
        //  stage.show();
        stage.showAndWait();


    }
}
