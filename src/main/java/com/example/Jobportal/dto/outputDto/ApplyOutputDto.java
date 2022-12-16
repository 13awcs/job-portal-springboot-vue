package com.example.Jobportal.dto.outputDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
public class ApplyOutputDto {
    private Long id;
    private String name;
    private String title;
    private LocalDate applyDate;
    private String status;
}
