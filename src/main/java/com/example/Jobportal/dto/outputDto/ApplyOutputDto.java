package com.example.Jobportal.dto.outputDto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate applyDate;
    private String status;
}
