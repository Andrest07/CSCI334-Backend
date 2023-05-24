package com.csci334.RCMS.service;

import com.csci334.RCMS.exceptions.CustomException;
import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.repository.SystemAdminRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminService {
    
    private final SystemAdminRepository systemAdminRepository;

    Logger log = LoggerFactory.getLogger(SystemAdminService.class);

    public SystemAdminService(SystemAdminRepository systemAdminRepository) {
        this.systemAdminRepository = systemAdminRepository;
    }

    public List<SystemAdmin> getSystemAdmins() {
		return systemAdminRepository.findAll();
	}

	public List<Long> getSystemAdminIds() {
		List<Long> ids = new ArrayList<Long>();
		List<SystemAdmin> systemAdmins = getSystemAdmins();
		for(int i=0;i<systemAdmins.size();i++) {
			ids.add(systemAdmins.get(i).getId());
		}
		return ids;
	}

    public SystemAdmin getSystemAdminById(Long id) throws Exception{
        return systemAdminRepository.findById(id).orElseThrow();
    }

    public SystemAdmin createSystemAdmin(SystemAdmin newSystemAdmin) {
        try {
            return systemAdminRepository.save(newSystemAdmin);
        } finally {
            log.info("Creating SystemAdmin: " + newSystemAdmin);
        }
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

    public SystemAdmin getSystemAdminFindUsername(String username) throws Exception{
        if(systemAdminRepository.findByUsername(username).isPresent()) {
            return systemAdminRepository.findByUsername(username).orElseThrow(() -> new Exception("Cannot find username"));
        }else{
            throw new CustomException("Incorrect Username or Password");
        }
    }

    public SystemAdmin getSystemAdminFindPassword(String password) throws Exception{
        if(systemAdminRepository.findByPassword(password).isPresent()) {
            return systemAdminRepository.findByPassword(password).orElseThrow(() -> new Exception("Cannot find password"));
        }else{
            throw new CustomException("Incorrect Username or Password");
        }
    }

    public void deleteSystemAdmin(Long id) throws Exception {
        log.info("Deleting SystemAdmin: " + getSystemAdminById(id));
        systemAdminRepository.deleteById(id);
    }
}
