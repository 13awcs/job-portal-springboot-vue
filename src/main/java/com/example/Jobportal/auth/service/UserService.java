package com.example.Jobportal.auth.service;

import com.example.Jobportal.auth.domain.RegistrationDto;
import com.example.Jobportal.auth.domain.Role;
import com.example.Jobportal.auth.domain.User;
import com.example.Jobportal.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

//    private final RoleService roleService;
//
//    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            user.getRoles().forEach(role -> {
//                authorities.add(new SimpleGrantedAuthority(role.getName()));
//            });
            authorities.add(new SimpleGrantedAuthority(user.getRole()));

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

//    public User create(RegistrationDto request) {
//        List<Role> roles = new ArrayList<>();
//        try {
//            roles.add(roleService.getByName(Role.ROLE_USER));
//        } catch (Exception ex) {}
//        return create(request, roles);
//    }
//
//    public User create(RegistrationDto request, List<Role> roles) {
//        User user = new User(request.name(), request.username(), passwordEncoder.encode(request.password()), roles);
//        save(user);
//        return user;
//    }

}
