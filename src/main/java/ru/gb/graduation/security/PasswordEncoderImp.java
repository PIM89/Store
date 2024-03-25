package ru.gb.graduation.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImp  implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
