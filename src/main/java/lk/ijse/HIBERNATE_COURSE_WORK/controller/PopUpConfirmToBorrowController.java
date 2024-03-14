package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 10:15 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PopUpConfirmToBorrowController {
    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnConfirm;
    private boolean isCancel;
    private boolean isConfirm;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(){
        isCancel=false;
        isConfirm=false;
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        isCancel=true;
        closeStage();
    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        isConfirm=true;
        closeStage();
    }

    public boolean isCanceled(){
        return isCancel;
    }
    public boolean isConfirmed(){
        return isConfirm;
    }
    private void closeStage() {
        if (stage != null) {
            stage.close();
        }
    }
}
