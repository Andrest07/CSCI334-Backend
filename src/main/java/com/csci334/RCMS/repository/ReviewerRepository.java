package com.csci334.RCMS.repository;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
    Optional<Reviewer> findByUsername(String s);
    Optional<Reviewer> findByPassword(String s);
}
