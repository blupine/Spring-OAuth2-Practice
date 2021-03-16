package com.bbolab.godingeta.account;

import com.bbolab.godingeta.AccountFactory;
import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.LoginRequestDto;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import com.bbolab.godingeta.account.respository.AccountRepository;
import com.bbolab.godingeta.account.service.AccountService;
import com.bbolab.godingeta.config.MockMvcTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@MockMvcTest
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountFactory accountFactory;

    @DisplayName("회원가입 요청 - 성공")
    @Test
    void 회원가입_성공() throws Exception {
        SignupRequestDto signupRequestDto = SignupRequestDto.of("testname", "test@test.com", "testpass");

        mockMvc.perform(post("/api/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(signupRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").hasJsonPath())
                .andExpect(jsonPath("email").hasJsonPath())
                .andExpect(jsonPath("_links").hasJsonPath())
                .andExpect(jsonPath("_links.self").hasJsonPath())
                .andExpect(jsonPath("_links.login").hasJsonPath())
                .andExpect(jsonPath("_links.profile").hasJsonPath())
                .andDo(document("signup",
                        links(
                                linkWithRel("self").description("Current requested URL"),
                                linkWithRel("login").description("Login request URL"),
                                linkWithRel("profile").description("API document URL")
                        ),
                        requestFields(
                                fieldWithPath("username").description("Username to signup"),
                                fieldWithPath("password").description("Password to signup"),
                                fieldWithPath("email").description("Email address to signup")
                        ),
                        responseFields(
                                fieldWithPath("username").description("Username"),
                                fieldWithPath("email").description("Email address"),
                                fieldWithPath("_links.self.href").description("Current requested URL"),
                                fieldWithPath("_links.login.href").description("Login request URL"),
                                fieldWithPath("_links.profile.href").description("Rest docs URL")
                        )
                ));

        Optional<Account> byUsername = accountRepository.findByUsername(signupRequestDto.getUsername());
        Assertions.assertTrue(byUsername.isPresent());
        Assertions.assertEquals(signupRequestDto.getUsername(), byUsername.get().getUsername());
    }

    @DisplayName("로그인 요청 - 성공")
    @Test
    void 로그인요청_성공() throws Exception {
        accountFactory.createAccount("testname");
        LoginRequestDto loginRequestDto = LoginRequestDto.of("testname", "testpass");
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(loginRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").hasJsonPath())
                .andExpect(jsonPath("email").hasJsonPath())
                .andExpect(jsonPath("jwtToken").hasJsonPath())
                .andExpect(jsonPath("_links").hasJsonPath())
                .andExpect(jsonPath("_links.self").hasJsonPath())
                .andExpect(jsonPath("_links.profile").hasJsonPath())
                .andDo(document("login",
                        links(
                                linkWithRel("self").description("Current requested URL"),
                                linkWithRel("profile").description("API document URL")
                        ),
                        requestFields(
                                fieldWithPath("username").description("Username to login"),
                                fieldWithPath("password").description("Password to signup")
                        ),
                        responseFields(
                                fieldWithPath("username").description("Username to signup"),
                                fieldWithPath("email").description("Email address to signup"),
                                fieldWithPath("jwtToken").description("JWT authentication token"),
                                fieldWithPath("_links.self.href").description("Current requested URL"),
                                fieldWithPath("_links.profile.href").description("Rest docs URL")
                        )
                ));

    }
}
