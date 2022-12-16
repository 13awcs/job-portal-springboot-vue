package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ApplyServiceImpl implements ApplyService {


    @Autowired
    private ApplyRepository applyRepository;

    public List<ApplyOutputDto> getApplyHasStatusByDate() {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();

        List<Apply> applies = applyRepository.getNewestApply();

        for (Apply apply : applies) {
            Long id = apply.getId();
            String name = apply.getCandidateApply().getName();
            String title = apply.getJobApply().getTitle();
            LocalDate applyDate = apply.getApplyDate();
            String status = apply.getStatus();

            ApplyOutputDto output = new ApplyOutputDto();
            output.setId(id);
            output.setName(name);
            output.setTitle(title);
            output.setApplyDate(applyDate);
            output.setStatus(status);

            applyOutputDtos.add(output);
        }

        return applyOutputDtos;
    }

    public List<ApplyOutputDto> getApplyHasNoStatusByDate() {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();

        List<Apply> applies = applyRepository.getNewestApplyHasNoStatus();

        for (Apply apply : applies) {
            Long id = apply.getId();
            String name = apply.getCandidateApply().getName();
            String title = apply.getJobApply().getTitle();
            LocalDate applyDate = apply.getApplyDate();
            String status = apply.getStatus();

            ApplyOutputDto output = new ApplyOutputDto();
            output.setId(id);
            output.setName(name);
            output.setTitle(title);
            output.setApplyDate(applyDate);
            output.setStatus(status);

            applyOutputDtos.add(output);
        }

        return applyOutputDtos;
    }

    @Transactional
    public String setStatus(Long id,String status) {
        applyRepository.setStatus(id,status);
        return "Set status successfully";
    }

    public List<ApplyOutputDto> searchApplyByStatus(String status) {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();
        List<Apply> applies = applyRepository.searchApplyByStatus(status);
        for (Apply apply : applies) {
            Long id = apply.getId();
            String name = apply.getCandidateApply().getName();
            String title = apply.getJobApply().getTitle();
            LocalDate applyDate = apply.getApplyDate();
            String statuss = apply.getStatus();

            ApplyOutputDto output = new ApplyOutputDto();
            output.setId(id);
            output.setName(name);
            output.setTitle(title);
            output.setApplyDate(applyDate);
            output.setStatus(statuss);

            applyOutputDtos.add(output);
        }

        return applyOutputDtos;
    }

}
