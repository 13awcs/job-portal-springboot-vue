package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.ApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {



    private final ApplyRepository applyRepository;

    public List<ApplyOutputDto> getApplyHasStatusByRecruiterIdAndSortByDate(Long recruiterId) {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();

        List<Apply> applies = applyRepository.getApplyHasStatusByRecruiterIdAndSortByDate(recruiterId);

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

    public List<ApplyOutputDto> getApplyHasNoStatusAndRecruiterIdAndSortByDate(Long recruierId) {
        List<ApplyOutputDto> applyOutputDtos = new ArrayList<>();

        List<Apply> applies = applyRepository.getApplyHasNoStatusByRecruiterIdAndSortByDate(recruierId);

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
