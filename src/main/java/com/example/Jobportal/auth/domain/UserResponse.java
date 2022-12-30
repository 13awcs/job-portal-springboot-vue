package com.example.Jobportal.auth.domain;
import com.example.Jobportal.model.Recruiter;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Setter
@Getter
public class UserResponse { //todo: split to other package for clean architecture
    private Long recruiterId;
    private String username;
    private String name;

    public static UserResponse fromEntity(User user){
        return UserResponse.builder()
                .recruiterId(user.getRecruiter().getId())
                .name(user.getRecruiter().getName())
                .username(user.getUsername())
                .build();
    }
}
