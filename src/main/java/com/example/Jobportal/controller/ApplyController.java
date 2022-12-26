package com.example.Jobportal.controller;

import com.example.Jobportal.common.ResponseObject;
import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.serviceImpl.ApplyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyRepository applyRepository;

    private final ApplyServiceImpl applyService;


    @GetMapping("/applies")
    public ResponseEntity<ResponseObject> getAllApply() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyRepository.findAll()));
    }

    @GetMapping("/applies/newest")
    public ResponseEntity<ResponseObject> getNewestApply() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(applyRepository.getNewestApply()));
    }

    @GetMapping("/applies/search")
    public ResponseEntity<Page<ApplyOutputDto>> searchApplyByStatus(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                                    @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                                                    @RequestParam(name = "sortField", defaultValue = "APPLY_DATE") String sortField,
                                                                    @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") Sort.Direction sortDir,
                                                                    @RequestParam(value = "status") String status) {
        Pageable pageable = PageRequest.of(page, size, sortDir, sortField);
        return ResponseEntity.ok(applyService.searchApplyByStatus(status, pageable));
    }

    @GetMapping("/applies/has-status/{recruiterId}")
    public ResponseEntity<Page<ApplyOutputDto>> getApplyHasStatusByDate(@PathVariable Long recruiterId, @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                                                                        @RequestParam(name = "sortField", defaultValue = "APPLY_DATE") String sortField,
                                                                        @RequestParam(name = "sortDir", defaultValue = "ASC") Sort.Direction sortDir) {
        Pageable pageable = PageRequest.of(page, size, sortDir, sortField);
        return ResponseEntity.ok(applyService.getApplyHasStatusByRecruiterIdAndSortByDate(recruiterId, pageable));
    }

    @GetMapping("/applies/has-no-status/{recruiterId}")
    public ResponseEntity<Page<ApplyOutputDto>> getApplyHasNoStatusByDate(@PathVariable Long recruiterId,
                                                                          @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                          @RequestParam(name = "size", defaultValue = "5") Integer size,
                                                                          @RequestParam(name = "sortField", defaultValue = "APPLY_DATE") String sortField,
                                                                          @RequestParam(name = "sortDir", defaultValue = "ASC") Sort.Direction sortDir) {
        Pageable pageable = PageRequest.of(page, size, sortDir, sortField);
        return ResponseEntity.ok(applyService.getApplyHasNoStatusAndRecruiterIdAndSortByDate(recruiterId, pageable));
    }

    @PostMapping("/applies/edit/{id}")
    public ResponseEntity<ResponseObject> setStatus(@PathVariable Long id, @RequestParam String status) {
        applyService.setStatus(id, status);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Set status successfully"));
    }

    @GetMapping("/admin/apply/statistic")
    public ResponseEntity<ResponseObject> countApplyByMonth(@RequestParam int year) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Success", applyService.countApplyByMonthAndYear(year)));
    }

}
