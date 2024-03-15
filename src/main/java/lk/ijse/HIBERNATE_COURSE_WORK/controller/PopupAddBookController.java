package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/15/2024 - 11:52 AM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.BookService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.LibraryBranchService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.BookServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.LibraryBranchServiceImpl;

import java.util.List;

public class PopupAddBookController {

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtGener;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtTitle;

    private LibraryBranchService libraryBranchService;
    private AdminService adminService;

    private BookService bookService;

    private long adminID;
    public void initialize(){
        libraryBranchService= LibraryBranchServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
        bookService= BookServiceImpl.getInstance();
        adminID=LoginPageController.adminId;

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) txtTitle.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(txtTitle.getText());
        bookDTO.setGener(txtGener.getText());
        bookDTO.setAuthor(txtAuthor.getText());
        bookDTO.setQty(Integer.parseInt(txtQty.getText()));

        List<LibraryBranchDTO> allLibraryBranches = libraryBranchService.getAllLibraryBranches();

        for (LibraryBranchDTO libraryBranchDTO:allLibraryBranches) {
            if (libraryBranchDTO.getName().equals(txtBranch.getText())){
                bookDTO.setLibraryBranch(libraryBranchDTO);
            }

        }
        AdminDTO admin = adminService.getAdmin(adminID);
        bookDTO.setAdmin(admin);

        Long bookId= bookService.saveBook(bookDTO);

        System.out.println("saved book Id:"+bookId);


    }
}
