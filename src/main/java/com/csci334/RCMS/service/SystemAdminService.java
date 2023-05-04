package com.csci334.RCMS.service;

import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.repository.SystemAdminRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminService {
    
    private final SystemAdminRepository systemAdminRepository;

    Logger log = LoggerFactory.getLogger(AuthorService.class);

    public SystemAdminService(SystemAdminRepository systemAdminRepository) {
        this.systemAdminRepository = systemAdminRepository;
    }

    public SystemAdmin getSystemAdminById(Long id) throws Exception{
        return systemAdminRepository.findById(id).orElseThrow();
    }

    public SystemAdmin createSystemAdmin(SystemAdmin newSystemAdmin) {
        log.info("Creating SystemAdmin: " + newSystemAdmin);
        return systemAdminRepository.save(newSystemAdmin);
    }

    public SystemAdmin updateSystemAdmin(SystemAdmin systemAdmin, Long id) throws Exception {
        SystemAdmin foundSystemAdmin = getSystemAdminById(id);
        if (foundSystemAdmin == null) {
            throw new Exception("System Admin invalid");
        }
        foundSystemAdmin.setSystemAdmin(systemAdmin);
        log.info("Updating SystemAdmin: " + foundSystemAdmin);
        return systemAdminRepository.save(foundSystemAdmin);
    }

    public void deleteSystemAdmin(Long id) throws Exception {
        log.info("Deleting SystemAdmin: " + getSystemAdminById(id));
        systemAdminRepository.deleteById(id);
    }
}
