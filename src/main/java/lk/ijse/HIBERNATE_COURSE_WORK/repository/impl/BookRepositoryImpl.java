package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:04 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Book;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.BookRepository;
import org.hibernate.Session;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private Session session;
    private static BookRepositoryImpl bookRepositoryImpl;
    private BookRepositoryImpl(){}

    public static BookRepositoryImpl getInstance(){
        return null==bookRepositoryImpl
                ?bookRepositoryImpl=new BookRepositoryImpl()
                :bookRepositoryImpl;
    }

    @Override
    public Long save(Book object) {
        return null;
    }

    @Override
    public void update(Book object) {

    }

    @Override
    public Book get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Book object) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
