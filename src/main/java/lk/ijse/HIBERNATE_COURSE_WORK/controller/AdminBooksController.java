package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/14/2024 - 5:58 PM 
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
import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Navigation;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Routes;
import lk.ijse.HIBERNATE_COURSE_WORK.service.BookService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.BookServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class AdminBooksController {
    @FXML
    private AnchorPane acrollAP;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    private BookService bookService;
    List<BookDTO>bookDTOList;
    public void initialize() throws IOException {
        bookService= BookServiceImpl.getInstance();
        getAllBooks();
        loadAllRows();
    }

    public void getAllBooks(){
        bookDTOList=bookService.getAllBooks();
    }
    @FXML
    void btnAddUserOnAction(ActionEvent event) throws IOException {
        Navigation.navigatePopUpWindow(Routes.ADDBOOK);
    }



    private void loadAllRows() throws IOException {
        //refresh view(clear old records before added new records)
        vBox.getChildren().clear();




        // get dto details to raws
        for (int i = 0; i < bookDTOList.size(); i++) {
            System.out.println("load rows");
            //create new v box to hold records
            VBox vBox1 = new VBox();
            vBox1.setSpacing(20);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/adminBookRow.fxml"));
            //create row controller
            AdminBookRowController adminBookRowController = new AdminBookRowController();
            //controller set to fxml
            fxmlLoader.setController(adminBookRowController);

            Node node = fxmlLoader.load();

            System.out.println("nod loaded");

            //set values to rows
            adminBookRowController.setId(bookDTOList.get(i).getId());
            adminBookRowController.setLblBookId(String.valueOf(bookDTOList.get(i).getId()));
            adminBookRowController.setLblBookTitle(bookDTOList.get(i).getTitle());
            adminBookRowController.setLblBookAuther(bookDTOList.get(i).getAuthor());
            adminBookRowController.setLblBookGener(bookDTOList.get(i).getGener());
            adminBookRowController.setLblBookQty(String.valueOf(bookDTOList.get(i).getQty()));
//            adminBookRowController.setLblBranch(bookDTOList.get(i).getLibraryBranch().getName());



            //get row buttons for set action
            JFXButton btnDelete = adminBookRowController.getBtnDelete();
            JFXButton btnUpdate = adminBookRowController.getBtnUpdate();


            //set actions to row buttons
            btnDelete.setOnAction(actionEvent -> {
                long id = adminBookRowController.getId();
                BookDTO book = bookService.getBook(id);

                boolean isDeleted = bookService.deleteBook(book);

                if (isDeleted){
                    System.out.println("book deleted");
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
