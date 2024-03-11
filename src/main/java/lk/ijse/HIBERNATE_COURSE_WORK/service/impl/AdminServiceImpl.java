package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:47 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.AdminRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.AdminRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import org.hibernate.Session;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private Session session;
    private static AdminService adminService;

    private final AdminRepository adminRepository;

    private AdminServiceImpl(){
        adminRepository=AdminRepositoryImpl.getInstance();
    }
    public static AdminService getInstance(){
        return null==adminService
                ?adminService=new AdminServiceImpl()
                :adminService;
    }

    @Override
    public Long saveAdmin(AdminDTO adminDTO) {
        return null;
    }

    @Override
    public AdminDTO getAdmin(long id) {
        return null;
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public boolean deleteAdmin(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public List<AdminDTO> getAllCustomers() {
        return null;
    }
}
