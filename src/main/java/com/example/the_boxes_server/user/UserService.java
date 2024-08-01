package com.example.the_boxes_server.user;

import com.example.the_boxes_server.core.JwtUtil;
import com.example.the_boxes_server.core.exceotions.Exception401;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 로그인 기능
    public String login(UserRequest.LoginDTO reqDTO) {
        User user = userRepository.findByEmailAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));

        String jwt = JwtUtil.userCreate(user);
        JwtUtil.userVerify(jwt);

        return jwt;
    }
}
