package com.example.Jobportal.repository;

import com.example.Jobportal.dto.outputDto.JobResponse;
import com.example.Jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    @Query(value = "select * from job j where j.recruiter_id = :id and j.active = 'true' order by j.create_at desc ",nativeQuery = true)
    List<Job> sortJobsByDate(Long id);

    @Query(value = "select * from job j where j.active = '' order by j.create_at desc ",nativeQuery = true)
    List<Job> getJobByActiveIsFalse();

    @Modifying
    @Query(value = "update job j set j.active = :active where j.id = :id",nativeQuery = true)
    void setActive(Long id,String active);

    @Query(value = "select * from job j where j.active = 'true'",nativeQuery = true)
    List<Job> getAllJobIsActive();

}
