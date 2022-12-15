package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ApplyServiceImpl implements ApplyService {


    @Autowired
    private ApplyRepository applyRepository;

    public List<ApplyOutputDto> getApplyByDate() {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();

        List<Apply> applies = applyRepository.getNewestApply();

        for (Apply apply : applies) {
            String name = apply.getCandidateApply().getName();
            String title = apply.getJobApply().getTitle();
            LocalDate applyDate = apply.getApplyDate();
            String status = apply.getStatus();

            ApplyOutputDto output = new ApplyOutputDto();
            output.setName(name);
            output.setTitle(title);
            output.setApplyDate(applyDate);
            output.setStatus(status);

            applyOutputDtos.add(output);
        }

        return applyOutputDtos;
    }

}
