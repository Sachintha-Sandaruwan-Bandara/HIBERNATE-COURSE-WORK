package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 2:50 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
public class BookCardController {

    @FXML
    private JFXButton btnBorrow;
    @FXML
    private ImageView bookImg;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGener;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblTitle;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ImageView getBookImg() {
        return bookImg;
    }

    public void setBookImg(ImageView bookImg) {
        this.bookImg = bookImg;
    }

    public Label getLblAuthor() {
        return lblAuthor;
    }

    public void setLblAuthor(String lblAuthor) {
        this.lblAuthor.setText(lblAuthor);
    }

    public Label getLblGener() {
        return lblGener;
    }

    public void setLblGener(String lblGener) {
        this.lblGener.setText(lblGener);
    }

    public Label getLblQty() {
        return lblQty;
    }

    public void setLblQty(int lblQty) {
        this.lblQty.setText(String.valueOf(lblQty));
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(String lblTitle) {
        this.lblTitle.setText(lblTitle);
    }

    public JFXButton getBtnBorrow() {
        return btnBorrow;
    }

    public void setBtnBorrow(JFXButton btnAddToCart) {
        this.btnBorrow = btnAddToCart;
    }
}
