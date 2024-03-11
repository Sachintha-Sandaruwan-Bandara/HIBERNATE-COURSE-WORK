package lk.ijse.HIBERNATE_COURSE_WORK.repository;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:09 PM 
*/

import org.hibernate.Session;

public interface SuperRepository {
    void setSession(Session session);
}
