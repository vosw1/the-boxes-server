package com.example.the_boxes_server.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration // IoC 컨테이너에 등록될 클래스
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("인터셉터 등록됨============================================================");

        // LoginInterceptor를 /api/** 경로에 적용
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**") // /api/ 하위 모든 요청에 대해 인터셉터 적용
                .excludePathPatterns("");  // 예외 패턴 설정 (현재는 빈 문자열로 모든 경로가 포함됨)
    }
}