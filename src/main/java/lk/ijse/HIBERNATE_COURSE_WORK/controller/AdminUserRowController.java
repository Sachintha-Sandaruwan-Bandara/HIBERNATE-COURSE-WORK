package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 7:27 PM 
*/
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class AdminUserRowController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblUserName;

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

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(String  lblEmail) {
        this.lblEmail.setText(lblEmail);
    }

    public Label getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(String lblPassword) {
        this.lblPassword.setText(lblPassword);
    }

    public Label getLblUserId() {
        return lblUserId;
    }

    public void setLblUserId(String lblUserId) {
        this.lblUserId.setText(lblUserId);
    }

    public Label getLblUserName() {
        return lblUserName;
    }

    public void setLblUserName(String lblUserName) {
        this.lblUserName.setText(lblUserName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
