package com.example.Jobportal.auth.domain;

import com.example.Jobportal.model.Recruiter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter
@Getter
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "appuser_roles",
//            joinColumns = @JoinColumn(name = "appuser_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recruiter_id", referencedColumnName = "id")
    private Recruiter recruiter;
    private String role;



    public User() {}

//    public User(String name, String username, String password, Collection<Role> roles) {
//        this.name = name;
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }


    public User(String username, String password,Recruiter recruiter, String role) {
        this.username = username;
        this.password = password;
        this.recruiter = recruiter;
        this.role = role;
    }
}
