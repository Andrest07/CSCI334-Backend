package com.csci334.RCMS.repository;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.SystemAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Long> {
    Optional<SystemAdmin> findByUsername(String s);
    Optional<SystemAdmin> findByPassword(String s);
}
