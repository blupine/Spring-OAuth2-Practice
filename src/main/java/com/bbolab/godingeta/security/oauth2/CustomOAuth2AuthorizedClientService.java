package com.bbolab.godingeta.security.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;

//TODO : OAuth2AuthorizedClientService 구현체 구현 필요 (acecess token, refresh token 관리 서비스)
//TODO : 아마도 해당 서비스가 access token을 관라하는 것으로 보임(refresh 후 저장 등) + OAuth2AuthorizedClientRepository 인터페이스도 스터디 필요
//@Service
public class CustomOAuth2AuthorizedClientService implements OAuth2AuthorizedClientService {
    @Override
    public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, String principalName) {
        return null;
    }

    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {

    }

    @Override
    public void removeAuthorizedClient(String clientRegistrationId, String principalName) {

    }
}
