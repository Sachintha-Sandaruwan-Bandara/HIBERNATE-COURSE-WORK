package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 9:18 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class AdminBranchRowController {
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblBranchId;

    @FXML
    private Label lblBranchLocation;

    @FXML
    private Label lblBranchName;

    private long id;

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

    public Label getLblBranchId() {
        return lblBranchId;
    }

    public void setLblBranchId(String lblBranchId) {
        this.lblBranchId.setText(lblBranchId);
    }

    public Label getLblBranchLocation() {
        return lblBranchLocation;
    }

    public void setLblBranchLocation(String lblBranchLocation) {
        this.lblBranchLocation.setText(lblBranchLocation);
    }

    public Label getLblBranchName() {
        return lblBranchName;
    }

    public void setLblBranchName(String lblBranchName) {
        this.lblBranchName.setText(lblBranchName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
