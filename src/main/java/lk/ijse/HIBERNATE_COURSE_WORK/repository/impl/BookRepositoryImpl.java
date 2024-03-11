package lk.ijse.HIBERNATE_COURSE_WORK.repository.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:04 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Book;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Long save(Book object) {
        return (Long) session.save(object);
    }

    @Override
    public void update(Book object) {
        session.update(object);
    }

    @Override
    public Book get(Long aLong) {
        return session.get(Book.class, aLong);
    }

    @Override
    public void delete(Book object) {
        session.delete(object);
    }

    @Override
    public List<Book> getAll() {
         String sqlQuery = "FROM Book";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;
    }


}
