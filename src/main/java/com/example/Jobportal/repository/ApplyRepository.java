package com.example.Jobportal.repository;

import com.example.Jobportal.dto.response.TopJobResponse;
import com.example.Jobportal.model.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    @Query(value = "select count(a.candidate_id) from apply a where a.job_id = :id ", nativeQuery = true)
    int countApply(Long id);

    @Query(value = "select * from apply p where p.status != '' order by p.apply_date DESC ", nativeQuery = true)
    List<Apply> getNewestApply();

    @Query(value = "select * from apply p where p.status = '' order by p.apply_date DESC ", nativeQuery = true)
    List<Apply> getNewestApplyHasNoStatus();

    @Query(value = "SELECT A.ID, A.CANDIDATE_ID,A.JOB_ID, A.APPLY_DATE, A.STATUS " +
            "FROM APPLY A JOIN JOB J ON A.JOB_ID = J.ID " +
            "WHERE J.RECRUITER_ID = :recruiterId " +
            "AND A.STATUS = ''",
            countQuery = "SELECT count(A.ID) " +
                    "FROM APPLY A JOIN JOB J ON A.JOB_ID = J.ID " +
                    "WHERE J.RECRUITER_ID = :recruiterId " +
                    "AND A.STATUS = ''",
            nativeQuery = true)
    Page<Apply> getApplyHasNoStatusByRecruiterIdAndSortByDate(Long recruiterId, Pageable pageable);

    @Query(value = "SELECT A.ID,A.CANDIDATE_ID,A.JOB_ID,A.APPLY_DATE,A.STATUS " +
            "FROM APPLY A JOIN JOB J ON A.JOB_ID = J.ID " +
            "WHERE J.RECRUITER_ID = :recruiterId AND A.STATUS != ''",
            countQuery = "Select count(A.ID) " +
                    "FROM APPLY A JOIN JOB J ON A.JOB_ID = J.ID " +
                    "WHERE J.RECRUITER_ID = :recruiterId AND A.STATUS != '' ",
            nativeQuery = true)
    Page<Apply> getApplyHasStatusByRecruiterIdAndSortByDate(Long recruiterId, Pageable pageable);

    @Query(value = "select p from Apply p join Job j on p.jobApply.id = j.id " +
            "where j.recruiter.id = ?2 and p.status like concat('%',?1,'%') ")
    Page<Apply> searchApplyByStatus(String status, Long id, Pageable pageable);

    @Modifying
    @Query(value = "update Apply p set p.status = :status where p.id = :id")
    void setStatus(Long id, String status);

    @Query(value = "SELECT J.TITLE,R.NAME,J.CREATE_AT as createdAt, COUNT(A.ID) AS amount " +
            "FROM APPLY A " +
            "JOIN JOB J ON A.JOB_ID = J.ID " +
            "JOIN RECRUITER R ON J.RECRUITER_ID = R.ID " +
            "GROUP BY A.JOB_ID ",
            nativeQuery = true)
    Page<TopJobResponse> getTopJob(Pageable pageable);
}
