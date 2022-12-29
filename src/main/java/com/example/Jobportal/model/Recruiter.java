package com.example.Jobportal.model;

import com.example.Jobportal.auth.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "recruiter")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "disable")
    private String disable = "false";

    @OneToOne(mappedBy = "recruiter")
    private User user;

    @OneToMany(mappedBy = "recruiter",cascade = CascadeType.ALL)
    @JsonBackReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Job> jobs;

}
