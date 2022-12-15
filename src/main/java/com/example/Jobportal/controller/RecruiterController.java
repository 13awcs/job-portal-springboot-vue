package com.example.Jobportal.controller;

import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.dto.LoginDto;
import com.example.Jobportal.dto.RegisterDto;
import com.example.Jobportal.dto.inputDto.RecruiterInput;
import com.example.Jobportal.model.Recruiter;
import com.example.Jobportal.repository.RecruiterRepository;
import com.example.Jobportal.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RecruiterController{
    @Autowired
    RecruiterService recruiterService;

    @Autowired
    RecruiterRepository recruiterRepository;


    @PostMapping("/register")
    public ResponseEntity<ResponseObject> register(@RequestBody RegisterDto registerDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        if(recruiterRepository.existsByUsername(registerDto.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Username is already taken !"));
        }else
        if(recruiterRepository.existsByEmail(registerDto.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Email is already taken !"));
        }
        recruiterService.registerRecruiter(registerDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Register successfully !",
                recruiterService.loadRecruiterByUsername(registerDto.getUsername())));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody LoginDto loginDto) {

        List<Recruiter> recruiters = recruiterRepository.findAll();
        for (Recruiter recruiter : recruiters) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (recruiter.getUsername().equalsIgnoreCase(loginDto.getUsername()) && encoder.matches(loginDto.getPassword(), recruiter.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Login successfully !",
                        recruiterService.loadRecruiterByUsername(loginDto.getUsername())));
            }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Username or password is wrong !"));

    }

    @GetMapping("/profile")
    public ResponseEntity<Recruiter> getProfile(@RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK).body(recruiterService.loadRecruiterByUsername(username));
    }

    @PostMapping("/profile/edit")
    public ResponseEntity<Recruiter> editProfile(@RequestParam Long id, @RequestBody RecruiterInput recruiterInput){
        return ResponseEntity.status(HttpStatus.OK).body(recruiterService.editProfile(id,recruiterInput));
    }

}
