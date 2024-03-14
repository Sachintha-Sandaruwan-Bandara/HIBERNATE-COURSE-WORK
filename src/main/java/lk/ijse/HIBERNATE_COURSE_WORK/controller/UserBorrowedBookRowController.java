package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 12:56 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class UserBorrowedBookRowController {

    @FXML
    private JFXButton btnReturn;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblReturnDone;

    private long id;

    public JFXButton getBtnReturn() {
        return btnReturn;
    }

    public void setBtnReturn(JFXButton btnReturn) {
        this.btnReturn = btnReturn;
    }

    public Label getLblBookTitle() {
        return lblBookTitle;
    }

    public void setLblBookTitle(String lblBookTitle) {
        this.lblBookTitle.setText(lblBookTitle);
    }

    public Label getLblBorrowedDate() {
        return lblBorrowedDate;
    }

    public void setLblBorrowedDate(String lblBorrowedDate) {
        this.lblBorrowedDate.setText(lblBorrowedDate);
    }

    public Label getLblDueDate() {
        return lblDueDate;
    }

    public void setLblDueDate(String lblDueDate) {
        this.lblDueDate.setText(lblDueDate);
    }

    public Label getLblReturnDone() {
        return lblReturnDone;
    }

    public void setLblReturnDone(Label lblReturnDone) {
        this.lblReturnDone = lblReturnDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
