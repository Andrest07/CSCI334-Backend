package com.csci334.RCMS.repository;

import com.csci334.RCMS.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
}