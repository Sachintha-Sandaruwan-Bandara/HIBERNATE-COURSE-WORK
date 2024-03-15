package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 1:30 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.TransactionDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.UserDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.BookService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.TransactionService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.UserService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.BookServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.TransactionServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.UserServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserBooksController {
    @FXML
    private TextField txtSearchBox;
    long userId;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;
    private BookService bookService;
    private UserService userService;
    private TransactionService transactionService;
    private List<BookDTO> allBooks;

    private List<BookDTO> searchResult;

    public void initialize() throws IOException {
        bookService = BookServiceImpl.getInstance();
        userService = UserServiceImpl.getInstance();
        transactionService = TransactionServiceImpl.getInstance();
        getAllBooks();
        loadAllBooks();
        userId = LoginPageController.userId;

    }

    private void getAllBooks() {
        allBooks = bookService.getAllBooks();
    }

    private void loadAllBooks() throws IOException {
        vbox1.getChildren().clear();
        vbox2.getChildren().clear();
        vbox3.getChildren().clear();
        vbox4.getChildren().clear();

        for (int i = 0; i < allBooks.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/bookCard.fxml"));

            BookCardController bookCardController = new BookCardController();

            fxmlLoader.setController(bookCardController);

            Node node = fxmlLoader.load();
            bookCardController.setId(allBooks.get(i).getId());
            bookCardController.setLblTitle(allBooks.get(i).getTitle());
            bookCardController.setLblAuthor(allBooks.get(i).getAuthor());
            bookCardController.setLblGener(allBooks.get(i).getGener());
            bookCardController.setLblQty(allBooks.get(i).getQty());

            if (i % 4 == 0) {
                setVBoxAndAction(vbox1, node, bookCardController);

            } else if (i % 4 == 1) {
                setVBoxAndAction(vbox2, node, bookCardController);
            } else if (i % 4 == 2) {
                setVBoxAndAction(vbox3, node, bookCardController);
            } else if (i % 4 == 3) {
                setVBoxAndAction(vbox4, node, bookCardController);
            }

            Long bookId = allBooks.get(i).getId();
        }
    }

    private void setVBoxAndAction(VBox vbox, Node node, BookCardController bookCardController) throws IOException {

        JFXButton btnBorrow = bookCardController.getBtnBorrow();

        long bookId = bookCardController.getId();

        btnBorrow.setOnAction(actionEvent -> {
            BookDTO exsistBook=bookService.getBook(bookId);
            //pothe qty ek 0 nam mukuth koranta bahane darling
            if (exsistBook.getQty()!=0) {

                //gannawada nadda confirm krgnn form ekk hdl eken cnfirm krd ndd kyl return krgnnw
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/popUpConfirmToBorrow.fxml"));

                PopUpConfirmToBorrowController popUpConfirmToBorrowController = new PopUpConfirmToBorrowController();

                fxmlLoader.setController(popUpConfirmToBorrowController);
                try {
                    Stage stage = new Stage();
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    popUpConfirmToBorrowController.setStage(stage);
                    stage.setScene(scene);
                    stage.showAndWait();

                    System.out.println(popUpConfirmToBorrowController.isCanceled());
                    System.out.println(popUpConfirmToBorrowController.isConfirmed());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (popUpConfirmToBorrowController.isConfirmed()) {
                    //gaththa potha get krgnnw psse ekn data arn dto ekkt dgnnw qty ek adu krl update kkrnw
                    BookDTO book = bookService.getBook(bookId);
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setId(book.getId());
                    bookDTO.setTitle(book.getTitle());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setGener(book.getGener());
                    bookDTO.setLibraryBranch(book.getLibraryBranch());
                    bookDTO.setTransactions(book.getTransactions());
                    if (book.getQty() != 0) {
                        bookDTO.setQty(book.getQty() - 1);
                    } else {
                        bookDTO.setQty(book.getQty());
                    }
                    boolean isBookUpdated = bookService.updateBook(bookDTO);
// transaction ekata danna hadaganna book dto eka
                    if (isBookUpdated) {
                        BookDTO book1 = bookService.getBook(bookId);
                        BookDTO bookDTO1 = new BookDTO();
                        bookDTO1.setId(book1.getId());
                        bookDTO1.setTitle(book1.getTitle());
                        bookDTO1.setAuthor(book1.getAuthor());
                        bookDTO1.setGener(book1.getGener());
                        bookDTO1.setLibraryBranch(book1.getLibraryBranch());
                        bookDTO1.setTransactions(book1.getTransactions());
                        bookDTO1.setQty(1);

                        //trnsaction ekt userw danna get krgnnw
                        UserDTO user = userService.getUser(userId);

                        TransactionDTO transactionDTO = new TransactionDTO();
                        transactionDTO.setUser(user);
                        transactionDTO.setBook(book1);

                        //add today to borrow date
                        LocalDate localDate = LocalDate.now();
                        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
                        transactionDTO.setBorrowDate(sqlDate);

                        //after 10 days for due date
                        LocalDate today = LocalDate.now();
                        LocalDate dueDate = today.plusDays(10);
                        java.sql.Date sqlDueDate = java.sql.Date.valueOf(dueDate);
                        transactionDTO.setDueDate(sqlDueDate);

                        transactionDTO.setQty(1);


                        //transaction save
                        Long savedTrsnsactionID = transactionService.saveTransaction(transactionDTO);


                        //user ge transaction ek usert dnwa

                        UserDTO userDTO = new UserDTO();
                        userDTO.setId(user.getId());
                        userDTO.setUsername(user.getUsername());
                        userDTO.setAdmin(user.getAdmin());
                        userDTO.setPassword(user.getPassword());
                        userDTO.setEmail(user.getEmail());

                        List<TransactionDTO> transactions = userDTO.getTransactions();
                        if (transactions == null) {
                            transactions = new ArrayList<>();
                        } else {
                            //get saved  transaction for add to user
                            TransactionDTO transaction = transactionService.getTransaction(savedTrsnsactionID);
                            boolean isAdded = transactions.add(transaction);

                            if (isAdded) {
                                System.out.println("transaction added to user");
                            }
                        }
                        boolean isUpdated = userService.updateUser(userDTO);

                        if (isUpdated) {
                            System.out.println("user updated");
                            try {
                                initialize();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Out of Stock");
                alert.setHeaderText(null);
                alert.setContentText("This book is currently out of stock.");

                alert.showAndWait();
            }
        });

        VBox vBox1 = new VBox(node);
        vbox.getChildren().add(vBox1);
        vbox.setSpacing(20);

    }


    @FXML
    void btnSearchOnAction(ActionEvent event) throws IOException {
        String search = txtSearchBox.getText().toLowerCase();
        if (!search.equals(null) && !search.isEmpty()) {

            List<BookDTO> searchResult = new ArrayList<>();

            for (BookDTO book : allBooks) {
                if (book.getTitle().toLowerCase().contains(search) ||
                        book.getAuthor().toLowerCase().contains(search) ||
                        book.getGener().toLowerCase().contains(search)) {
                    searchResult.add(book);
                }
            }

            loadSearch(searchResult);
        }
    }

    private void loadSearch(List<BookDTO>searchResult) throws IOException {
        vbox1.getChildren().clear();
        vbox2.getChildren().clear();
        vbox3.getChildren().clear();
        vbox4.getChildren().clear();

        for (int i = 0; i < searchResult.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/bookCard.fxml"));

            BookCardController bookCardController = new BookCardController();

            fxmlLoader.setController(bookCardController);

            Node node = fxmlLoader.load();
            bookCardController.setId(searchResult.get(i).getId());
            bookCardController.setLblTitle(searchResult.get(i).getTitle());
            bookCardController.setLblAuthor(searchResult.get(i).getAuthor());
            bookCardController.setLblGener(searchResult.get(i).getGener());
            bookCardController.setLblQty(searchResult.get(i).getQty());

            if (i % 4 == 0) {
                setVBoxAndAction(vbox1, node, bookCardController);

            } else if (i % 4 == 1) {
                setVBoxAndAction(vbox2, node, bookCardController);
            } else if (i % 4 == 2) {
                setVBoxAndAction(vbox3, node, bookCardController);
            } else if (i % 4 == 3) {
                setVBoxAndAction(vbox4, node, bookCardController);
            }

            Long bookId = searchResult.get(i).getId();
        }
    }

}
