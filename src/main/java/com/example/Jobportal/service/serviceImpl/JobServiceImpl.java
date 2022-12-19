package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.common.exceptions.ResourceNotFoundException;
import com.example.Jobportal.dto.Mapping.JobMapping;
import com.example.Jobportal.dto.inputDto.JobEditDto;
import com.example.Jobportal.dto.inputDto.JobInputDto;
import com.example.Jobportal.dto.outputDto.CandidateOutputDto;
import com.example.Jobportal.dto.outputDto.JobOutputDto;
import com.example.Jobportal.dto.outputDto.JobResponse;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.model.Candidate;
import com.example.Jobportal.model.Job;
import com.example.Jobportal.model.Recruiter;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.repository.JobRepository;
import com.example.Jobportal.repository.RecruiterRepository;
import com.example.Jobportal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final RecruiterRepository recruiterRepository;
    private final ApplyRepository applyRepository;

    @Override
    public Job createJob(JobInputDto jobInputDto) {

        Recruiter recruiter = recruiterRepository.findById(jobInputDto.getRecruiterId())
                .orElseThrow(()-> new ResourceNotFoundException("Not found recruiter id "+jobInputDto.getRecruiterId()));
        Job job = JobMapping.toJob(jobInputDto);
        job.setRecruiter(recruiter);
        return jobRepository.save(job);

    }

    @Override
    @Transactional
    public Job editJob(Long id, JobEditDto jobEditDto) {
        Job jobFromDb = jobRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found job id "+id));

        Job jobEdit = new Job();
        jobEdit.setId(id);
        jobEdit.setTitle(jobEditDto.getTitle());
        jobEdit.setCategory(jobFromDb.getCategory());
        jobEdit.setAmount(jobFromDb.getAmount());
        jobEdit.setType(jobFromDb.getType());
        jobEdit.setLevel(jobEditDto.getLevel());
        jobEdit.setDeadline(jobFromDb.getDeadline());
        jobEdit.setDescription(jobFromDb.getDescription());
        jobEdit.setCompanyName(jobFromDb.getCompanyName());
        jobEdit.setSalary(jobEditDto.getSalary());
        jobEdit.setLocation(jobEditDto.getLocation());
        jobEdit.setStatus(jobFromDb.getStatus());
        jobEdit.setCreateAt(jobFromDb.getCreateAt());
        jobEdit.setRecruiter(jobFromDb.getRecruiter());

        return jobRepository.save(jobEdit);
    }

    @Override
    public String deleteJob(Long id) {

        Job job = jobRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found job id "+id));
        jobRepository.deleteById(id);
        return "Deleted successfully job id "+id;
    }

    @Override
    public List<JobOutputDto> findJobByCategory(String category) {
        return null;
    }

    @Override
    public List<JobOutputDto> sortJobByDate(Long id) {

        List<JobOutputDto> jobOutputDtos = new ArrayList<>();

        List<Job> jobs = jobRepository.sortJobsByDate(id);
        if(jobs.isEmpty()){
            new ResourceNotFoundException("No result !");
        }
        for(Job job : jobs){
            int applyAmount = applyRepository.countApply(job.getId());
            JobOutputDto jobOutputDto = JobMapping.jobInputToOutput(job);
            jobOutputDto.setApplyAmount(applyAmount);
            jobOutputDtos.add(jobOutputDto);
        }

        return jobOutputDtos;
    }

    @Override
    public Job getDetailJob(Long id) {
        Job job = jobRepository.findById(id).orElseThrow();
        return job;
    }

    public JobResponse getJobByApplyId(Long applyId) {
        Apply apply = applyRepository.findById(applyId).orElseThrow();
        Job job = apply.getJobApply();
        return JobResponse.fromEntity(job);
    }
}
