package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/13/2024 - 1:30 PM 
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
import java.util.ArrayList;
import java.util.List;

public class UserBooksController {

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
    long userId;


    public void initialize() throws IOException {
        bookService = BookServiceImpl.getInstance();
        userService= UserServiceImpl.getInstance();
        transactionService= TransactionServiceImpl.getInstance();
        getAllBooks();
        loadAllBooks();
        userId=LoginPageController.userId;

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

            Long bookId= allBooks.get(i).getId();
        }
    }

    private void setVBoxAndAction(VBox vbox, Node node, BookCardController bookCardController) throws IOException {

        JFXButton btnBorrow = bookCardController.getBtnBorrow();

        long bookId= bookCardController.getId();

        btnBorrow.setOnAction(actionEvent -> {
            System.out.println(bookId + "btn clicked");
            System.out.println("btn clicked bla");
            BookDTO book = bookService.getBook(bookId);
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bookId);
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setGener(book.getGener());
            int qty = book.getQty();
            bookDTO.setQty(qty - 1);

            boolean b = bookService.updateBook(bookDTO);
            if (b) {

                try {
                    initialize();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("updated");
                    UserDTO user = userService.getUser(userId);

                    TransactionDTO transactionDTO = new TransactionDTO();
                    transactionDTO.setBook(book);
                    transactionDTO.setUser(user);

                    Long aLong = transactionService.saveTransaction(transactionDTO);






            }

        });

  VBox vBox1 = new VBox(node);
        vbox.getChildren().add(vBox1);
        vbox.setSpacing(20);

    }

}
