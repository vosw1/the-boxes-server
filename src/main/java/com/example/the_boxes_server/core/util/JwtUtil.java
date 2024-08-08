package com.example.the_boxes_server.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.the_boxes_server.user.SessionUser;
import com.example.the_boxes_server.user.User;

import java.util.Date;

public class JwtUtil {
    public static String create(User user) {
        String jwt = JWT.create()
                .withSubject("blog")
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .withClaim("id", user.getUserId())
                .sign(Algorithm.HMAC512("theboxes"));

        return jwt;
    }

    public static SessionUser verify(String jwt) {
        System.out.println(jwt);

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("theboxes")).build().verify(jwt);
        int id = decodedJWT.getClaim("id").asInt();

        return SessionUser.builder()
                .id(id)
                .build();
    }
}