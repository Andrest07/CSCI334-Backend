package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SystemAdminController {
    @Autowired
    private final SystemAdminService systemAdminService;

    public SystemAdminController(SystemAdminService systemAdminService) {
        this.systemAdminService = systemAdminService;
    }

    @GetMapping("/systemadmin/{id}")
    SystemAdmin getSystemAdminById(@PathVariable Long id) throws Exception {
        return systemAdminService.getSystemAdminById(id);
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
    void deleteSystemAdmin(@PathVariable Long id) {
        systemAdminService.deleteSystemAdmin(id);
    }
}
