package com.example.Jobportal.repository;


import com.example.Jobportal.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {
    @Query(value = "select * from recruiter r where r.username = :username", nativeQuery = true)
    Recruiter findByUsername(@Param("username") String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
