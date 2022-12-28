package com.example.Jobportal.auth.service;

import com.example.Jobportal.auth.domain.RegistrationDto;
import com.example.Jobportal.auth.domain.Role;
import com.example.Jobportal.auth.domain.User;
import com.example.Jobportal.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CreatorService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleService roleService;

    public final User save(User user) {
        return userRepository.save(user);
    }

    public User create(RegistrationDto request, List<Role> roles) {
        User user = new User(request.name(), request.username(), passwordEncoder.encode(request.password()), roles);
        save(user);
        return user;
    }

    public User create(RegistrationDto request) {
        List<Role> roles = new ArrayList<>();
        try {
            roles.add(roleService.getByName(Role.ROLE_USER));
        } catch (Exception ex) {}
        return create(request, roles);
    }
}