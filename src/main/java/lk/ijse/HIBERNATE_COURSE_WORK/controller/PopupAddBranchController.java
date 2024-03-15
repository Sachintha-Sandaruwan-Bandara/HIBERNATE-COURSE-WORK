package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/15/2024 - 12:33 PM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.LibraryBranchService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.LibraryBranchServiceImpl;

public class PopupAddBranchController {
    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtName;

    private long adminId;

    private LibraryBranchService libraryBranchService;

    private AdminService adminService;

    public void initialize(){
        libraryBranchService= LibraryBranchServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
        adminId=LoginPageController.adminId;

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) txtLocation.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        LibraryBranchDTO libraryBranchDTO = new LibraryBranchDTO();
        libraryBranchDTO.setLocation(txtLocation.getText());
        libraryBranchDTO.setName(txtName.getText());

        AdminDTO admin = adminService.getAdmin(adminId);
        libraryBranchDTO.setAdmin(admin);

        Long branchId = libraryBranchService.saveLibraryBranch(libraryBranchDTO);

        System.out.println("saved branch ID:"+branchId);


    }
}
