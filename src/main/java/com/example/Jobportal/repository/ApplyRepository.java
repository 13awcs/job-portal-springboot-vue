package com.example.Jobportal.repository;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.model.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, CompositeKey> {

    @Query(value = "select count(a.candidate_id) from apply a where a.job_id = :id ",nativeQuery = true)
    int countApply(Long id);

    @Query(value = "select * from apply p where p.status != '' order by p.apply_date DESC ",nativeQuery = true)
    List<Apply> getNewestApply();

    @Query(value = "select * from apply p where p.status = '' order by p.apply_date DESC ",nativeQuery = true)
    List<Apply> getNewestApplyHasNoStatus();

    @Query(value = "select * from apply p where p.status like :status", nativeQuery = true)
    List<Apply> searchApplyByStatus(String status);

    @Modifying
    @Query(value = "update apply p set p.status = :status where p.id = :id",nativeQuery = true)
    void setStatus(Long id,String status);
}
