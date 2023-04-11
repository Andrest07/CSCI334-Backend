package com.csci334.RCMS.service;

import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.repository.SystemAdminRepository;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminService {
    private final SystemAdminRepository systemAdminRepository;

    public SystemAdminService(SystemAdminRepository systemAdminRepository) {
        this.systemAdminRepository = systemAdminRepository;
    }

    public SystemAdmin getSystemAdminById(Long id) throws Exception{
        return systemAdminRepository.findById(id).orElseThrow();
    }

    public SystemAdmin createSystemAdmin(SystemAdmin newSystemAdmin) {
        return systemAdminRepository.save(newSystemAdmin);
    }

    public SystemAdmin updateSystemAdmin(SystemAdmin systemAdmin, Long id) throws Exception {
        SystemAdmin foundSystemAdmin = getSystemAdminById(id);
        if (foundSystemAdmin == null) {
            throw new Exception("System Admin invalid");
        }
        foundSystemAdmin.setSystemAdmin(systemAdmin);
        return systemAdminRepository.save(foundSystemAdmin);
    }

    public void deleteSystemAdmin(Long id) {
        systemAdminRepository.deleteById(id);
    }
}
