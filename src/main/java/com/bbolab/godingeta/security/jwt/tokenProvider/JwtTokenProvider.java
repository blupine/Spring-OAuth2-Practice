package com.bbolab.godingeta.security.jwt.tokenProvider;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public interface JwtTokenProvider {

    public String createToken(String userPk);

    public Authentication getAuthentication(String token);

    public String getUserPk(String token);

    public String resolveToken(HttpServletRequest request);

    public boolean validateToken(String token);
}
