package com.example.the_boxes_server.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.the_boxes_server.core.exceotions.Exception401;
import com.example.the_boxes_server.core.exceotions.Exception500;
import com.example.the_boxes_server.user.User;
import com.example.the_boxes_server.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // JWT 토큰 추출
        String jwt = request.getHeader("Authorization");

        // JWT 토큰이 없을 경우 예외 처리
        if (jwt == null) {
            throw new Exception401("JWT 토큰을 전달해주세요");
        }

        // Bearer 접두사 제거
        jwt = jwt.replace("Bearer ", "");

        try {
            // JWT 검증
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("theboxes")).build().verify(jwt);
            int userId = decodedJWT.getClaim("id").asInt();

            // 사용자 정보 설정
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new Exception401("존재하지 않는 사용자입니다"));

            // 사용자 정보를 요청에 설정
            request.setAttribute("user", user);

            return true;
        } catch (TokenExpiredException e) {
            throw new Exception401("토큰 만료시간이 지났어요. 다시 로그인하세요");
        } catch (JWTDecodeException e) {
            throw new Exception401("토큰이 유효하지 않습니다");
        } catch (Exception e) {
            e.printStackTrace(); // 개발 시 테스트 보기
            throw new Exception500(e.getMessage()); // 알 수 없는 오류
        }
    }
}