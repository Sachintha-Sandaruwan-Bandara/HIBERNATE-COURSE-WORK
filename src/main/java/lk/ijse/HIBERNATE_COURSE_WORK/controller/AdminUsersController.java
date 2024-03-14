package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 5:59 PM 
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
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

public class AdminUsersController {
    @FXML
    private AnchorPane acrollAP;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    private UserService userService;

    private List<UserDTO>userDTOList;


    public void initialize() throws IOException {
        userService= UserServiceImpl.getInstance();
        getAllUsers();
        loadAllRows();

    }
    public void getAllUsers(){
        userDTOList=userService.getAllUsers();
    }

    @FXML
    void btnAddUserOnAction(ActionEvent event) {

    }
    private void loadAllRows() throws IOException {
        //refresh view(clear old records before added new records)
        vBox.getChildren().clear();


        // get dto details to raws
        for (int i = 0; i < userDTOList.size(); i++) {
            System.out.println("load rows");
            //create new v box to hold records
            VBox vBox1 = new VBox();
            vBox1.setSpacing(20);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/adminUserRow.fxml"));
            //create row controller
            AdminUserRowController adminUserRowController = new AdminUserRowController();
            //controller set to fxml
            fxmlLoader.setController(adminUserRowController);

            Node node = fxmlLoader.load();

            System.out.println("nod loaded");

            //set values to rows
            adminUserRowController.setId(userDTOList.get(i).getId());
            adminUserRowController.setLblUserId(String.valueOf(userDTOList.get(i).getId()));
            adminUserRowController.setLblUserName(userDTOList.get(i).getUsername());
            adminUserRowController.setLblEmail(userDTOList.get(i).getEmail());
            adminUserRowController.setLblPassword(userDTOList.get(i).getPassword());


            //get row buttons for set action
            JFXButton btnDelete = adminUserRowController.getBtnDelete();
            JFXButton btnUpdate = adminUserRowController.getBtnUpdate();


            //set actions to row buttons
            btnDelete.setOnAction(actionEvent -> {
                long id = adminUserRowController.getId();
                UserDTO user = userService.getUser(id);

                boolean isDeleted = userService.deleteUser(user);

                if (isDeleted) {
                    System.out.println("user deleted");
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

}
