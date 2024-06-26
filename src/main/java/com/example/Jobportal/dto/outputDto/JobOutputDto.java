package com.example.Jobportal.dto.outputDto;

import com.example.Jobportal.model.Job;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
@Data
@Setter
@Getter
@ToString
public class JobOutputDto {
    private Long id;
    private String title;
    private String category;
    private int amount;
    private String type;
    private String level;
    private LocalDate deadline;
    private String description;
    private String companyName;
    private Float salary;
    private String location;
    private String status;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate createAt;
    private int applyAmount;
}
