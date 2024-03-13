package lk.ijse.HIBERNATE_COURSE_WORK.service.impl;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 9:47 PM 
*/

import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminAuthDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.Admin;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.AdminRepository;
import lk.ijse.HIBERNATE_COURSE_WORK.repository.impl.AdminRepositoryImpl;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.util.SessionFactoryConfig;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private Session session;
    private static AdminService adminService;

    private final AdminRepository adminRepository;

    private List<AdminDTO>adminDTOList;

    private AdminServiceImpl(){
        adminRepository=AdminRepositoryImpl.getInstance();
        adminDTOList=getAllAdmins();
    }
    public static AdminService getInstance(){
        return null==adminService
                ?adminService=new AdminServiceImpl()
                :adminService;
    }

    @Override
    public Long saveAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            Long id = adminRepository.save(adminDTO.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public AdminDTO getAdmin(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            adminRepository.setSession(session);
            Admin admin = adminRepository.get(id);
            session.close();
            return admin.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.update(adminDTO.toEntity());
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.delete(adminDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        adminRepository.setSession(session);
        List<Admin> allAdmins= adminRepository.getAll();
        List<AdminDTO> adminDTOList = new ArrayList<>();
        for (Admin admin : allAdmins) {
            adminDTOList.add(admin.toDTO());
        }
        return adminDTOList;
    }
    @Override
    public AdminAuthDTO authenticate(String username, String password) {
        AdminAuthDTO adminAuthDTO = new AdminAuthDTO();
        for (AdminDTO admin : adminDTOList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                Long id = admin.getId();
                adminAuthDTO.setId(id);
                adminAuthDTO.setFlag(true);
                return adminAuthDTO;
            }
        }

        return adminAuthDTO;
    }
}
