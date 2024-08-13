package com.example.the_boxes_server.user;

import com.example.the_boxes_server.core.exceotions.Exception400;
import com.example.the_boxes_server.core.util.JwtUtil;
import com.example.the_boxes_server.core.exceotions.Exception401;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 로그인 기능
    public String login(UserRequest.LoginDTO reqDTO) {
        User user = userRepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));

        String jwt = JwtUtil.create(user);
        JwtUtil.verify(jwt);

        return jwt;
    }


    public Optional<User> findByUsername(String username){
        Optional<User> userOP = userRepository.findByUsername(username);

        if (userOP.isPresent()) {
            throw new Exception400("중복된 유저네임입니다");
        }

        return userOP;
    }


    // 회원 가입
    @Transactional
    public String joinAndLogin(UserRequest.JoinDTO reqDTO) {

        // 회원 가입
        User joinUser = userRepository.save(reqDTO.toEntity());

        // 로그인
        String jwt = JwtUtil.create(joinUser);
        JwtUtil.verify(jwt);

        return jwt;
    }

    @Transactional
    public UserResponse.LoginDTO loginByDTO(UserRequest.LoginDTO reqDTO) {
        User user = userRepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));

        return new UserResponse.LoginDTO(user);
    }

    @Transactional
    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public UserResponse.JoinDTO joinByDTO(UserRequest.JoinDTO reqDTO) {
        User user = userRepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));

        return new UserResponse.JoinDTO(user);
    }
}
