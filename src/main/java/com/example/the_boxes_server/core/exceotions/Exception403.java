package com.example.the_boxes_server.core.exceotions;

import com.example.the_boxes_server.core.util.ApiUtil;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 권한 없음
@Getter
public class Exception403 extends RuntimeException {
    public Exception403(String message) {
        super(message);
    }

    public ApiUtil.ApiResult<?> body() {
        return ApiUtil.error(getMessage(), HttpStatus.FORBIDDEN);
    }

    public HttpStatus status() {
        return HttpStatus.FORBIDDEN;
    }
}