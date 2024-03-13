package lk.ijse.HIBERNATE_COURSE_WORK.service;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:43 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;

import java.util.List;


public interface AdminService extends SuperService{
    Long saveAdmin(AdminDTO adminDTO);

    AdminDTO getAdmin(long id);

    boolean updateAdmin(AdminDTO adminDTO);

    boolean deleteAdmin(AdminDTO adminDTO);

    List<AdminDTO> getAllAdmins();

   boolean authenticate(String username, String password);


}
