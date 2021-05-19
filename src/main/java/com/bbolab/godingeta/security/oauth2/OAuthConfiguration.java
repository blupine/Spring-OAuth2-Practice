package com.bbolab.godingeta.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class OAuthConfiguration {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> providers = CustomOAuthProvider.oAuthProviders.stream()
                .map(c -> c.getBuilder().build()).collect(Collectors.toList());
        return new InMemoryClientRegistrationRepository(providers);
    }
}
