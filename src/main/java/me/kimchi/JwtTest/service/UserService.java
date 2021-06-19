package me.kimchi.JwtTest.service;

import lombok.RequiredArgsConstructor;
import me.kimchi.JwtTest.dto.UserDto;
import me.kimchi.JwtTest.entity.Authority;
import me.kimchi.JwtTest.entity.User;
import me.kimchi.JwtTest.repository.UserRepository;
import me.kimchi.JwtTest.util.SecurityUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(UserDto userDto) {
        if(userRepository.findOneWithAuthoritiesByUsername(userDto.getUserName()).orElse(null) != null) {
            throw new RuntimeException("this username is already exist.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .username(userDto.getUserName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickName())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities(){
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }


}
