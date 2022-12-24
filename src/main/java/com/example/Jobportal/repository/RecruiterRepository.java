package com.example.Jobportal.repository;


import com.example.Jobportal.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {
    @Query(value = "select * from recruiter r where r.username = :username", nativeQuery = true)
    Recruiter findByUsername(@Param("username") String username);

    @Modifying
    @Query(value = "update recruiter r set r.disable = :disable where r.id = :id",nativeQuery = true)
    void setDisable(Long id, String disable);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
