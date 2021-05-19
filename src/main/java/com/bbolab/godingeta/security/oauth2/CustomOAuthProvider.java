package com.bbolab.godingeta.security.oauth2;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.Arrays;
import java.util.List;

public enum CustomOAuthProvider {
    NAVER {
        @Override
        public ClientRegistration.Builder getBuilder() {
            return getBuilder("naver", ClientAuthenticationMethod.POST)
                    .scope("profile")
                    .authorizationUri("https://nid.naver.com/oauth2.0/authorize")
                    .tokenUri("https://nid.naver.com/oauth2.0/token")
                    .userInfoUri("https://openapi.naver.com/v1/nid/me")
                    .clientId("ZXmx2ue7CuTgJw52MFUh")
                    .clientSecret("SZ6kf3SBKy")
                    .userNameAttributeName("response")
                    .clientName("Naver");
        }
    },
    KAKAO {

        @Override
        public ClientRegistration.Builder getBuilder() {
            return getBuilder("kakao", ClientAuthenticationMethod.POST)
                    .scope("profile")
                    .authorizationUri("https://kauth.kakao.com/oauth/authorize")
                    .tokenUri("https://kauth.kakao.com/oauth/token")
                    .userInfoUri("https://kapi.kakao.com/v2/user/me")
                    .clientId("df558539d52941403071fa6b9c3e1c60")
                    .clientSecret("Xva57W8O3zObZy4IPoP004aamYV7WgXG")
                    .userNameAttributeName("id")
                    .clientName("Kakao");
        }

    };


    private static final String DEFAULT_LOGIN_REDIRECT_URL = "{baseUrl}/login/oauth2/code/{registrationId}";

    protected final ClientRegistration.Builder getBuilder(String registrationId,
                                                          ClientAuthenticationMethod method) {
        ClientRegistration.Builder builder = ClientRegistration.withRegistrationId(registrationId);
        builder.clientAuthenticationMethod(method);
        builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
        builder.redirectUri(CustomOAuthProvider.DEFAULT_LOGIN_REDIRECT_URL);
        return builder;
    }

    public abstract ClientRegistration.Builder getBuilder();

    public static final List<CustomOAuthProvider> oAuthProviders = Arrays.asList(NAVER, KAKAO);
}
