package ru.gb.graduation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.graduation.model.User;
import ru.gb.graduation.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public boolean existsByName(String userName) {
       return userRepository.existsByName(userName);
    }

    public User save(User user) {
        userRepository.save(user);
        userRepository.flush();
        return user;
    }
}
