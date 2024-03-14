package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 6:01 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.LibraryBranchDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.LibraryBranchService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.LibraryBranchServiceImpl;

import java.io.IOException;
import java.util.List;

public class AdminBranchesController {
    @FXML
    private AnchorPane acrollAP;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;
    private LibraryBranchService libraryBranchService;

    private List<LibraryBranchDTO> libraryBranchDTOList;

    public void initialize() throws IOException {
        libraryBranchService= LibraryBranchServiceImpl.getInstance();
        loadAllBranches();
        loadAllRows();

    }

    private void loadAllRows() throws IOException {
        //refresh view(clear old records before added new records)
        vBox.getChildren().clear();


        // get dto details to raws
        for (int i = 0; i < libraryBranchDTOList.size(); i++) {
            System.out.println("load rows");
            //create new v box to hold records
            VBox vBox1 = new VBox();
            vBox1.setSpacing(20);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/adminBranchRow.fxml"));
            //create row controller
            AdminBranchRowController adminBranchRowController = new AdminBranchRowController();
            //controller set to fxml
            fxmlLoader.setController(adminBranchRowController);

            Node node = fxmlLoader.load();

            System.out.println("nod loaded");

            //set values to rows
           adminBranchRowController.setId(libraryBranchDTOList.get(i).getId());
           adminBranchRowController.setLblBranchId(String.valueOf(libraryBranchDTOList.get(i).getId()));
           adminBranchRowController.setLblBranchName(libraryBranchDTOList.get(i).getName());
           adminBranchRowController.setLblBranchLocation(libraryBranchDTOList.get(i).getLocation());



            //get row buttons for set action
            JFXButton btnDelete = adminBranchRowController.getBtnDelete();
            JFXButton btnUpdate = adminBranchRowController.getBtnUpdate();


            //set actions to row buttons
            btnDelete.setOnAction(actionEvent -> {
                long id = adminBranchRowController.getId();
                LibraryBranchDTO libraryBranch = libraryBranchService.getLibraryBranch(id);

                boolean isDeleted =libraryBranchService.deleteLibraryBranch(libraryBranch);

                if (isDeleted) {
                    System.out.println("branch deleted");
                }

            });

            btnUpdate.setOnAction(actionEvent -> {
                System.out.println("update button clicked");

            });


            vBox1.getChildren().clear();
            vBox1.getChildren().add(node);
            vBox.getChildren().add(vBox1);


        }
    }
    public void loadAllBranches(){
        libraryBranchDTOList=libraryBranchService.getAllLibraryBranches();
    }

    @FXML
    void btnAddBranchOnAction(ActionEvent event) {

    }


}
