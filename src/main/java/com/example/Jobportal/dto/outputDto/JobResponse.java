package com.example.Jobportal.dto.outputDto;

import com.example.Jobportal.model.Job;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class JobResponse {
    private String title;
    private int amount;
    private String type;
    private String level;
    private LocalDate deadline;
    private String description;
    private String companyName;
    private Float salary;
    private String location;

    public static JobResponse fromEntity(Job job) {
        return JobResponse.builder()
                .title(job.getTitle())
                .amount(job.getAmount())
                .type(job.getType())
                .level(job.getLevel())
                .deadline(job.getDeadline())
                .description(job.getDescription())
                .companyName(job.getCompanyName())
                .salary(job.getSalary())
                .location(job.getLocation())
                .build();
    }
}
