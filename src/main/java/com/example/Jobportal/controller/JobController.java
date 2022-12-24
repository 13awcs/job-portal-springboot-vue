package com.example.Jobportal.controller;


import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.dto.inputDto.JobEditDto;
import com.example.Jobportal.dto.inputDto.JobInputDto;
import com.example.Jobportal.dto.outputDto.JobOutputDto;
import com.example.Jobportal.model.Job;
import com.example.Jobportal.repository.JobRepository;
import com.example.Jobportal.service.JobService;
import com.example.Jobportal.service.serviceImpl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
public class JobController{

    private final JobService jobService;

    private final JobRepository jobRepository;

    private final JobServiceImpl jobServiceImpl;

    @GetMapping("/jobs/recruiter/{id}")
    public List<JobOutputDto> getAllJobsByRecruiterId(@PathVariable Long id){
        return jobService.sortJobByDate(id);

    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobRepository.findAll();

    }

    @PostMapping("/jobs/create")
    public ResponseEntity<ResponseObject> createJob(@RequestBody JobInputDto jobInputDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Create job successfully !",jobService.createJob(jobInputDto)));

    }

    @PutMapping("/jobs/edit/{id}")
    public ResponseEntity<ResponseObject> editJob(@PathVariable Long id,@RequestBody JobEditDto jobInputDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Edit job successfully !",jobService.editJob(id,jobInputDto)));
    }

    @DeleteMapping("/jobs/delete/{id}")
    public ResponseEntity<ResponseObject> deleteJob(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(jobService.deleteJob(id)));
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getDetailJob(id));
    }

    @GetMapping("/jobs/job-by-apply-id/{applyId}")
    public ResponseEntity<ResponseObject> getJobByApplyId(@PathVariable Long applyId){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(jobServiceImpl.getJobByApplyId(applyId)));
    }

    @PostMapping("/jobs/set-active/{id}")
    public ResponseEntity<ResponseObject> setActive(@PathVariable Long id,@RequestParam String active){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(jobServiceImpl.setActive(id,active)));
    }

    @GetMapping("/admin/jobs-not-active")
    public ResponseEntity<ResponseObject> getJobByActiveIsFalse(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(jobServiceImpl.getJobByActiveIsFalse()));
    }

}
