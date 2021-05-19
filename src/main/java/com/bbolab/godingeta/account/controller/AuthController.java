package com.bbolab.godingeta.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AuthController {
//
//    @GetMapping("/auth/kakao/login-callback")
//    public ResponseEntity kakaoLoginCallback(String code) {
//        RestTemplate rt = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", "df558539d52941403071fa6b9c3e1c60");
//        params.add("redirect_uri", "http://localhost:8080/auth/kakao/login");
//        params.add("code", code);
//
//        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = rt.exchange(
//                "https://kauth.kakao.com/oauth/token",
//                HttpMethod.POST,
//                kakaoTokenRequest,
//                String.class
//        );
//        return response;
//    }
//
//    @GetMapping("/auth/naver/login-callback")
//    public ResponseEntity naverLoginCallback(String code, String state) {
//        RestTemplate rt = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", "ZXmx2ue7CuTgJw52MFUh");
//        params.add("client_secret", "SZ6kf3SBKy");
//        params.add("code", code);
//        params.add("state", state);
//
//        HttpEntity<MultiValueMap<String, String>> naverTokenRequest = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = rt.exchange(
//                "https://nid.naver.com/oauth2.0/token",
//                HttpMethod.POST,
//                naverTokenRequest,
//                String.class
//        );
//        return response;
//    }
//
//    @PostMapping("/auth/naver/login")
//    public ResponseEntity naverLogin(String accessToken) {
//        RestTemplate rt = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + accessToken);
//        HttpEntity<String> naverProfileRequest = new HttpEntity<>(headers);
//        ResponseEntity<String> responseEntity = rt.exchange(
//                "https://openapi.naver.com/v1/nid/me",
//                HttpMethod.GET,
//                null,
//                String.class
//        );
//
//    }
}
