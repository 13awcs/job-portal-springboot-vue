package com.example.Jobportal.controller;


import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.model.Candidate;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.repository.CandidateRepository;
import com.example.Jobportal.service.serviceImpl.ApplyServiceImpl;
import com.example.Jobportal.service.serviceImpl.CandidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateRepository candidateRepository;

    private final CandidateServiceImpl candidateService;

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidate(){
        return candidateRepository.findAll();
    }

    @GetMapping("/candidate/{id}")
    public Optional<Candidate> getCandidateById(@RequestParam Long id){
        return candidateRepository.findById(id);
    }

    @GetMapping("/candidates/search")
    public ResponseEntity<List<Candidate>> searchCandidate(@RequestParam String keyword){
        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.searchCandidate(keyword));
    }

    @GetMapping("/candidate-by-apply-id/{applyId}")
    public ResponseEntity<ResponseObject> getCandidateProfileByApplyId(@PathVariable Long applyId){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(candidateService.getCandidateProfileByApplyId(applyId)));
    }
}
