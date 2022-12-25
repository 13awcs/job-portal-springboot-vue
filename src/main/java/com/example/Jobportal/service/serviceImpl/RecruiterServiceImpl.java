package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.RegisterDto;
import com.example.Jobportal.dto.inputDto.RecruiterInput;
import com.example.Jobportal.dto.outputDto.RecruiterResponse;
import com.example.Jobportal.model.Job;
import com.example.Jobportal.model.Recruiter;
import com.example.Jobportal.repository.JobRepository;
import com.example.Jobportal.repository.RecruiterRepository;
import com.example.Jobportal.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {
    private final JobRepository jobRepository;
    private final RecruiterRepository recruiterRepository;
    @Override
    public Recruiter registerRecruiter(RegisterDto registerDto) {
        Recruiter recruiter = new Recruiter();
        recruiter.setUsername(registerDto.getUsername());
        recruiter.setEmail(registerDto.getEmail());
        //recruiter.setPassword(this.passwordEncoder.encode(registerDto.getPassword()));
        recruiter.setPassword(registerDto.getPassword());
        return recruiterRepository.save(recruiter);
    }

    @Override
    public Recruiter loadRecruiterByUsername(String username) {
        Recruiter recruiter = recruiterRepository.findByUsername(username);
        return recruiter;
//        Recruiter recruiter = recruiterRepository.

    }

    @Override
    public Recruiter editProfile(Long id, RecruiterInput recruiterInput) {
        Recruiter recruiter = new Recruiter();
        recruiter.setAvatar(recruiterInput.getAvatar());
        recruiter.setEmail(recruiterInput.getEmail());
        recruiter.setPhone(recruiterInput.getPhone());
        recruiter.setCompanyName(recruiterInput.getCompanyName());
        recruiter.setId(id);
        return recruiterRepository.save(recruiter);
    }

    public RecruiterResponse getRecruiterByJobId(Long jobId){
        Job job = jobRepository.findById(jobId).orElseThrow();
        Recruiter recruiter = recruiterRepository.findById(job.getRecruiter().getId()).orElseThrow();
        return RecruiterResponse.fromEntity(recruiter);
    }


    @Transactional
    public String setDisable(Long id, String disable) {
        Job job = jobRepository.findById(id).orElseThrow();
        recruiterRepository.setDisable(job.getRecruiter().getId(),disable);
        return "Set disable successfully";
    }
}
