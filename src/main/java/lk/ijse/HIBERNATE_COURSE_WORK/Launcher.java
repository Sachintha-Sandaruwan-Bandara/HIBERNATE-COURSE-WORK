package lk.ijse.HIBERNATE_COURSE_WORK;
/* 
    @author Sachi_S_Bandara
    @created 2/29/2024 - 9:54 PM 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Launcher.class.getResource("/view/loginPage.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);


        stage.setTitle("");
        stage.show();

    }
}
