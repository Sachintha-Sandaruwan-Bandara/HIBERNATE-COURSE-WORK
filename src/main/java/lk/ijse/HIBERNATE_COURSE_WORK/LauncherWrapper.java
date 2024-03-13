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
        Launcher.main(args);
    }
}
