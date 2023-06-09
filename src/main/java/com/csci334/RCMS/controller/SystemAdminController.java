package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.service.SystemAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SystemAdminController {
    @Autowired
    private final SystemAdminService systemAdminService;

    public SystemAdminController(SystemAdminService systemAdminService) {
        this.systemAdminService = systemAdminService;
    }

    @GetMapping("/systemAdmins")
	List<SystemAdmin> all() {
		return systemAdminService.getSystemAdmins();
	}

	@GetMapping("/systemAdmins/ids")
	List<Long> getSystemAdminIds(){
		return systemAdminService.getSystemAdminIds();
	}

    @GetMapping("/systemadmin/{id}")
    SystemAdmin getSystemAdminById(@PathVariable Long id) throws Exception {
        return systemAdminService.getSystemAdminById(id);
    }

    @GetMapping("/systemadmin/findSystemAdminUsername/{username}")
    SystemAdmin getSystemAdminFindUsername(@PathVariable String username) throws Exception {
        return systemAdminService.getSystemAdminFindUsername(username);
    }

    @GetMapping("/systemadmin/findSystemAdminPassword/{password}")
    SystemAdmin getSystemAdminFindPassword(@PathVariable String password) throws Exception {
        return systemAdminService.getSystemAdminFindPassword(password);
    }

    @PostMapping("/createSystemAdmin")
    SystemAdmin createSystemAdmin(@RequestBody SystemAdmin newSystemAdmin) {
        return systemAdminService.createSystemAdmin(newSystemAdmin);
    }

    @PutMapping("/updateSystemAdmin/{id}")
    SystemAdmin updateSystemAdmin(@RequestBody SystemAdmin systemAdmin, @PathVariable Long id) throws Exception {
        return systemAdminService.updateSystemAdmin(systemAdmin, id);
    }

    @DeleteMapping({"/deleteSystemAdmin/{id}"})
    void deleteSystemAdmin(@PathVariable Long id) throws Exception {
        systemAdminService.deleteSystemAdmin(id);
    }
}
