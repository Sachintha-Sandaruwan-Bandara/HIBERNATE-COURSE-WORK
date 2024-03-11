package lk.ijse.HIBERNATE_COURSE_WORK;
/* 
    @author Sachi_S_Bandara
    @created 2/29/2024 - 9:54 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.BookDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LauncherWrapper {
    public static void main(String[] args) {
//        Launcher.main(args);

//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        transaction.commit();
//        session.close();
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUsername("namal");
        adminDTO.setPassword("sfjsj");

        List<BookDTO>bookDTOS=new ArrayList<>();
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor("kumal");

        bookDTOS.add(bookDTO);

        adminDTO.setBooks(bookDTOS);

        AdminService instance = AdminServiceImpl.getInstance();
        Long aLong = instance.saveAdmin(adminDTO);

        System.out.println(aLong);
    }
}
