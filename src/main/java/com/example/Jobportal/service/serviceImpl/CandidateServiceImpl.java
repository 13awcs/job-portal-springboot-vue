package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.outputDto.CandidateOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.model.Candidate;
import com.example.Jobportal.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl {
    private final ApplyRepository applyRepository;

    public CandidateOutputDto getCandidateByApplyId(Long applyId) {
        Apply apply = applyRepository.findById(applyId).orElseThrow(); //todo: throw what? must handle carefully
        Candidate candidate = apply.getCandidateApply();
        return CandidateOutputDto.fromEntity(candidate);
    }
}
