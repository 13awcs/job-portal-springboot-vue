package com.example.Jobportal.controller;

import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.dto.LoginDto;
import com.example.Jobportal.dto.RegisterDto;
import com.example.Jobportal.dto.inputDto.RecruiterInput;
import com.example.Jobportal.dto.outputDto.RecruiterResponse;
import com.example.Jobportal.model.Recruiter;
import com.example.Jobportal.repository.RecruiterRepository;
import com.example.Jobportal.service.RecruiterService;
import com.example.Jobportal.service.serviceImpl.RecruiterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
public class RecruiterController{

    private  final RecruiterService recruiterService;

    private final RecruiterServiceImpl recruiterServiceImpl;

    private final  RecruiterRepository recruiterRepository;


//    @PostMapping("/register")
//    public ResponseEntity<ResponseObject> register(@RequestBody RegisterDto registerDto){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//        if(recruiterRepository.existsByUsername(registerDto.getUsername())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Username is already taken !"));
//        }else
//        if(recruiterRepository.existsByEmail(registerDto.getEmail())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Email is already taken !"));
//        }
//        recruiterService.registerRecruiter(registerDto);
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Register successfully !",
//                recruiterService.loadRecruiterByUsername(registerDto.getUsername())));
//    }

//    @PostMapping("/login")
//    public ResponseEntity<ResponseObject> login(@RequestBody LoginDto loginDto) {
//
//        List<Recruiter> recruiters = recruiterRepository.findAll();
//        for (Recruiter recruiter : recruiters) {
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//            if (recruiter.getUsername().equalsIgnoreCase(loginDto.getUsername()) && encoder.matches(loginDto.getPassword(), recruiter.getPassword())) {
//                if(recruiter.getDisable().equals(new String("false"))) {
//                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Login successfully !",
//                            recruiterService.loadRecruiterByUsername(loginDto.getUsername())));
//                }
//                else {
//                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Your account is disable !"));
//                }
//            }
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("Username or password is wrong !"));
//
//    }

    @GetMapping("/profile")
    public ResponseEntity<Recruiter> getProfile(@RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK).body(recruiterService.loadRecruiterByUsername(username));
    }

    @PostMapping("/profile/edit")
    public ResponseEntity<Recruiter> editProfile(@RequestParam Long id, @RequestBody RecruiterInput recruiterInput){
        return ResponseEntity.status(HttpStatus.OK).body(recruiterService.editProfile(id,recruiterInput));
    }

    @GetMapping("/admin/recruiter/{jobId}")
    public ResponseEntity<ResponseObject> getRecruiterByJobId(@PathVariable Long  jobId){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(recruiterServiceImpl.getRecruiterByJobId(jobId)));
    }

    @PostMapping("/admin/disable-recruiter/{id}")
    public ResponseEntity<ResponseObject> setDisable(@PathVariable Long  id, @RequestParam String disable){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully",recruiterServiceImpl.setDisable(id,disable)));
    }

    @GetMapping("/admin/recruiter/get-top")
    public ResponseEntity<ResponseObject> getTopRecruiter(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(recruiterServiceImpl.getTopRecruiter()));
    }

}
