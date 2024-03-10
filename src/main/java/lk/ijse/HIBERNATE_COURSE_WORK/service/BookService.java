package lk.ijse.HIBERNATE_COURSE_WORK.service;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:45 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;

import java.util.List;

public interface BookService extends SuperService{
    Long saveBook(BookDTO bookDTO);

   BookDTO getBook(long id);

    boolean updateBook(BookDTO bookDTO);

    boolean deleteBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();
}
