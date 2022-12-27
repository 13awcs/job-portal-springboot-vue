package com.example.Jobportal.service.serviceImpl;

import com.example.Jobportal.dto.outputDto.ApplyOutputDto;
import com.example.Jobportal.dto.response.TopJobResponse;
import com.example.Jobportal.model.Apply;
import com.example.Jobportal.model.Job;
import com.example.Jobportal.repository.ApplyRepository;
import com.example.Jobportal.service.ApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {



    private final ApplyRepository applyRepository;

    public Page<ApplyOutputDto> getApplyHasStatusByRecruiterIdAndSortByDate(Long recruiterId,Pageable pageable) {
        Page<ApplyOutputDto> applies = applyRepository.getApplyHasStatusByRecruiterIdAndSortByDate(recruiterId,pageable).map(ApplyOutputDto::fromEntity);
        return applies;
    }

    public Page<ApplyOutputDto> getApplyHasNoStatusAndRecruiterIdAndSortByDate(Long recruiterId, Pageable pageable) {
        return applyRepository.getApplyHasNoStatusByRecruiterIdAndSortByDate(recruiterId,pageable).map(ApplyOutputDto::fromEntity);
    }

    @Transactional
    public String setStatus(Long id,String status) {
        applyRepository.setStatus(id,status);
        return "Set status successfully";
    }

    public Page<ApplyOutputDto> searchApplyByStatus(String status,Long id,Pageable pageable) {
        return applyRepository.searchApplyByStatus(status,id,pageable).map(ApplyOutputDto::fromEntity);
    }

    public List<Integer> countApplyByMonthAndYear(int year){
        List<Apply> list = applyRepository.findAll().stream()
                .filter(y -> y.getApplyDate().getYear() == year)
                .collect(Collectors.toList());
        List<Integer> listApply = new ArrayList<>();
        for (int i=1; i<=12;i++) {
            int month = i;
            Long count = list.stream()
                    .filter(m -> m.getApplyDate().getMonth().getValue() == month)
                    .count();
            listApply.add(count.intValue());
        }
        return listApply;
    }

    public Page<TopJobResponse> getTopJob(Pageable pageable) {
        return applyRepository.getTopJob(pageable);
    }

}
