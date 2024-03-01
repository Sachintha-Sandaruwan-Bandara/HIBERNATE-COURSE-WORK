package lk.ijse.HIBERNATE_COURSE_WORK.util;
/* 
    @author Sachi_S_Bandara
    @created 2/29/2024 - 9:58 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory = new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(LibraryBranch.class)
                .addAnnotatedClass(Transaction.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return sessionFactoryConfig==null?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

}
