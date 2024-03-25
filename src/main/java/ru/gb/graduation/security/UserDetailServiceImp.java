package ru.gb.graduation.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.gb.graduation.model.Role;
import ru.gb.graduation.model.User;
import ru.gb.graduation.repository.UserRepository;
import ru.gb.graduation.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> currentUser = userService.findUserByName(username);
        if (currentUser.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(currentUser.get().getRole().name()));
        return new org.springframework.security.core.userdetails.User(
                currentUser.get().getName(),
                currentUser.get().getPassword(),
                authorityList);
    }
    @PostConstruct
    public void addAdmin() {
        if (!userService.existsByName("admin")) {
            User user = new User();
            user.setName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setRole(Role.ADMIN);
            userService.save(user);
        }
    }
}
