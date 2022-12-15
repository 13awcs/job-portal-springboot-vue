package com.example.Jobportal.repository;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.model.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, CompositeKey> {

    @Query(value = "select count(a.candidate_id) from apply a where a.job_id = :id ",nativeQuery = true)
    int countApply(Long id);

    @Query(value = "select * from apply p order by p.apply_date DESC ",nativeQuery = true)
    List<Apply> getNewestApply();

//    @Query(value = "SELECT new com.example.Jobportal.dto.outputDto.ApplyOutputDto(C.name,J.title,A.apply_date,A.status) FROM APPLY  A JOIN CANDIDATE C JOIN JOB J WHERE A.CANDIDATE_ID = C.ID AND A.JOB_ID = J.ID ORDER BY A.APPLY_DATE DESC ",nativeQuery = true)
//    List<ApplyOutputDto> getApplyByDateQuery();

    @Query(value = "select * from apply p where p.status like :status", nativeQuery = true)
    List<Apply> searchApplyByStatus(String status);
}
