package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 1:31 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.TransactionService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.TransactionServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserBorrowdBooksController {

    @FXML
    private AnchorPane scrollAp;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    private TransactionService transactionService;

   private List<TransactionDTO> allTransactions;

   private List<TransactionDTO>userTransactions;

   private long userId;
    public void initialize() throws IOException {
        transactionService= TransactionServiceImpl.getInstance();
        userTransactions=new ArrayList<>();
       this.userId=LoginPageController.userId;

       loadAllTransactions();
       getUserTransactions();
       loadAllRows();
    }

    private void loadAllTransactions() {
        System.out.println("load all ek");
        allTransactions= transactionService.getAllTransactions();
        System.out.println(allTransactions);
    }

    private void getUserTransactions() {
        System.out.println("get all user ek");
        for (int i = 0; i < allTransactions.size(); i++) {

            if (allTransactions.get(i).getUser().getId()==userId){
                System.out.println("user id :"+allTransactions.get(i).getUser().getId());

                userTransactions.add(allTransactions.get(i));
            }
        }
        System.out.println("get all user iwrai");
    }


    public void loadAllRows() throws IOException {
        //refresh view(clear old records before added new records)
        vbox.getChildren().clear();

        for (int i = 0; i < userTransactions.size(); i++) {
            System.out.println(i+"user transactions");
            System.out.println(userTransactions);
        }



        // get dto details to raws
        for (int i = 0; i < userTransactions.size(); i++) {
            System.out.println("load rows");
            //create new v box to hold records
            VBox vBox1 = new VBox();
            vBox1.setSpacing(20);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/userBorrowedBookRow.fxml"));
            //create row controller
            UserBorrowedBookRowController userBorrowedBookRowController = new UserBorrowedBookRowController();
            //controller set to fxml
            fxmlLoader.setController(userBorrowedBookRowController);

            Node node = fxmlLoader.load();

            System.out.println("nod loaded");

            //set values to rows
           userBorrowedBookRowController.setId(userTransactions.get(i).getId());
           userBorrowedBookRowController.setLblBookTitle(userTransactions.get(i).getBook().getTitle());
           userBorrowedBookRowController.setLblBorrowedDate(String.valueOf(userTransactions.get(i).getBorrowDate()));
           userBorrowedBookRowController.setLblDueDate(String.valueOf(userTransactions.get(i).getDueDate()));
           if (userTransactions.get(i).getReturnDate()==null){
               userBorrowedBookRowController.getLblReturnDone().setVisible(false);
           }else {
               userBorrowedBookRowController.getBtnReturn().setVisible(false);
           }

            //get row buttons for set action
            JFXButton btnReturn = userBorrowedBookRowController.getBtnReturn();


            //set actions to row buttons
           btnReturn.setOnAction(actionEvent -> {

               System.out.println("btn return clicked");
               long id = userBorrowedBookRowController.getId();
               TransactionDTO transaction = transactionService.getTransaction(id);
               TransactionDTO transactionDTO = new TransactionDTO();
               transactionDTO.setId(transaction.getId());
               transactionDTO.setUser(transaction.getUser());
               transactionDTO.setBook(transaction.getBook());
               transactionDTO.setQty(transaction.getQty());
               transactionDTO.setDueDate(transaction.getDueDate());
               transactionDTO.setBorrowDate(transaction.getBorrowDate());

               LocalDate localDate = LocalDate.now();
               java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
               transactionDTO.setReturnDate(sqlDate);

               boolean b = transactionService.updateTransaction(transactionDTO);

               if (b){
                   System.out.println("return complete");
                   try {
                       initialize();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               }


           });



            vBox1.getChildren().clear();
            vBox1.getChildren().add(node);
            vbox.getChildren().add(vBox1);



        }

    }

}
