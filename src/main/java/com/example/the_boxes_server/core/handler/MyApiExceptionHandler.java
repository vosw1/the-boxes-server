package com.example.the_boxes_server.core.handler;

import com.example.the_boxes_server.core.exceotions.*;
import com.example.the_boxes_server.core.util.ApiUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// RuntimeException이 터지면 해당 파일로 오류가 모인다
@RestControllerAdvice // 데이터 응답
public class MyApiExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> badRequest(Exception400 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        log.warn("400 : " + e.getMessage());
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> unAuthorized(Exception401 e, HttpServletRequest request) {
        log.warn("401 : " + e.getMessage());
        log.warn("IP : " + request.getRemoteAddr());
        log.warn("Agent : " + request.getHeader("User-Agent"));
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> forbidden(Exception403 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        log.warn("403 : " + e.getMessage());
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> notFound(Exception404 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        log.info("404 : " + e.getMessage());
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(Exception500 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        log.error("500 : " + e.getMessage());
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknownServerError(Exception e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        log.error("500 : " + e.getMessage());
        ApiUtil.ApiResult<?> apiResult = ApiUtil.error("unknown server error", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
