package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:48 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.BookRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.BookRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.BookService;
import org.hibernate.Session;

import java.util.List;

public class BookServiceImpl implements BookService {
    private Session session;
    private static BookService bookService;
    private final BookRepository bookRepository;

    private BookServiceImpl(){
        bookRepository=BookRepositoryImpl.getInstance();
    }
    public static BookService getInstance(){
        return null==bookService
                ?bookService=new BookServiceImpl()
                :bookService;
    }
    @Override
    public Long saveBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookDTO getBook(long id) {
        return null;
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        return false;
    }

    @Override
    public boolean deleteBook(BookDTO bookDTO) {
        return false;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return null;
    }
}
