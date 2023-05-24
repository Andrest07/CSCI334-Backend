package com.csci334.RCMS.repository;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    Optional<Conference> findByUsername(String s);
    Optional<Conference> findByPassword(String s);

}
