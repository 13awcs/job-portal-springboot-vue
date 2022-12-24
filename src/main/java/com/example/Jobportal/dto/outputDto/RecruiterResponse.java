package com.example.Jobportal.dto.outputDto;

import com.example.Jobportal.model.Job;
import com.example.Jobportal.model.Recruiter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class RecruiterResponse {
    private String name;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dob;
    private String address;
    private String companyName;
    private String email;
    private String phone;
    private String avatar;

    public static RecruiterResponse fromEntity(Recruiter recruiter) {
        return RecruiterResponse.builder()
                .name(recruiter.getName())
                .dob(recruiter.getDob())
                .address(recruiter.getAddress())
                .companyName(recruiter.getCompanyName())
                .email(recruiter.getEmail())
                .phone(recruiter.getPhone())
                .avatar(recruiter.getAvatar())
                .build();
    }

}
