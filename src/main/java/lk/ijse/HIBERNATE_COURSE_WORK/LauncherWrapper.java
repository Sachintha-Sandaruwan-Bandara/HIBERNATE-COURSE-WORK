package lk.ijse.HIBERNATE_COURSE_WORK;
/* 
    @author Sachi_S_Bandara
    @created 2/29/2024 - 9:54 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LauncherWrapper {
    public static void main(String[] args) {
        Launcher.main(args);

//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        transaction.commit();
//        session.close();
    }
}
