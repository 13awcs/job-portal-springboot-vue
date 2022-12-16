package com.example.Jobportal.controller;

import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.serviceImpl.ApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ApplyController {

    @Autowired
    ApplyRepository applyRepository;

    @Autowired
    ApplyServiceImpl applyService;

    @GetMapping("/applies")
    public ResponseEntity<ResponseObject> getAllApply(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyRepository.findAll()));
    }

    @GetMapping("/applies/newest")
    public ResponseEntity<ResponseObject> getNewestApply(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyRepository.getNewestApply()));
    }

    @GetMapping("/applies/search")
    public ResponseEntity<ResponseObject> searchApplyByStatus(@RequestParam String status){
        List<ApplyOutputDto> applyList = applyService.searchApplyByStatus(status);
        if(applyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("No result found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyList));
    }

    @GetMapping("/applies/has-status")
    public ResponseEntity<ResponseObject> getApplyHasStatusByDate(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyService.getApplyHasStatusByDate()));
    }

    @GetMapping("/applies/has-no-status")
    public ResponseEntity<ResponseObject> getApplyHasNoStatusByDate(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyService.getApplyHasNoStatusByDate()));
    }

    @PostMapping("/applies/edit/{id}")
    public ResponseEntity<ResponseObject> setStatus(@PathVariable Long id,@RequestParam String status){
        applyService.setStatus(id,status);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Set status successfully"));
    }

}
