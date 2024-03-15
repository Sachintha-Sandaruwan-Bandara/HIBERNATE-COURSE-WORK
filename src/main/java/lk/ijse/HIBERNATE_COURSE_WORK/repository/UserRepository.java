package lk.ijse.HIBERNATE_COURSE_WORK.repository;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:02 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long>{
    List<User>getOverDueUsers();
}
