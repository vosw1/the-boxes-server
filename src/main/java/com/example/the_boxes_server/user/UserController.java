package com.example.the_boxes_server.user;

import com.example.the_boxes_server.core.util.ApiUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "/home";
    }

    // 회원 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRequest.LoginDTO reqDTO, Errors errors) {
        String jwt = userService.login(reqDTO);
        UserResponse.LoginDTO respDTO = userService.loginByDTO(reqDTO);
        return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).body(new ApiUtil<>(respDTO));
    }

    // 회원 가입
    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody UserRequest.JoinDTO reqDTO, Errors errors) {

        String jwt = userService.joinAndLogin(reqDTO);
        UserResponse.JoinDTO respDTO = userService.joinByDTO(reqDTO);
        return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).body(new ApiUtil<>(respDTO));
    }


    //회원가입 시 아이디 체크확인
    @GetMapping("/username-same-check")
    public @ResponseBody ApiUtil<?> usernameSameCheck(String username){
        Optional userOp = userService.findByUsername(username);
        if (userOp == null) {
            return new ApiUtil<>(true);
        } else {
            return new ApiUtil<>(false);
        }
    }
}