package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 6:33 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class AdminBookRowController {
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblBookAuther;

    @FXML
    private Label lblBookGener;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookQty;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblBranch;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JFXButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JFXButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JFXButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JFXButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public Label getLblBookAuther() {
        return lblBookAuther;
    }

    public void setLblBookAuther(String lblBookAuther) {
        this.lblBookAuther.setText(lblBookAuther);
    }

    public Label getLblBookGener() {
        return lblBookGener;
    }

    public void setLblBookGener(String lblBookGener) {
        this.lblBookGener.setText(lblBookGener);
    }

    public Label getLblBookId() {
        return lblBookId;
    }

    public void setLblBookId(String lblBookId) {
        this.lblBookId.setText(lblBookId);
    }

    public Label getLblBookQty() {
        return lblBookQty;
    }

    public void setLblBookQty(String lblBookQty) {
        this.lblBookQty.setText(lblBookQty);
    }

    public Label getLblBookTitle() {
        return lblBookTitle;
    }

    public void setLblBookTitle(String lblBookTitle) {
        this.lblBookTitle.setText(lblBookTitle);
    }

    public Label getLblBranch() {
        return lblBranch;
    }

    public void setLblBranch(String lblBranch) {
        this.lblBranch.setText(lblBranch);
    }
}
