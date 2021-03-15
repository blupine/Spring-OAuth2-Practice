package com.bbolab.godingeta.account.controller;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import com.bbolab.godingeta.account.dto.SignupResultDto;
import com.bbolab.godingeta.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final ModelMapper modelMapper;
    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid SignupRequestDto signupRequestDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // TODO : bindingResult 확인해보기
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Account result = accountService.signup(signupRequestDto);
        SignupResultDto resultDto = modelMapper.map(result, SignupResultDto.class);

        EntityModel<SignupResultDto> entityModel = EntityModel.of(resultDto);
        entityModel.add(WebMvcLinkBuilder.linkTo(AccountController.class).slash("signup").withSelfRel());
        entityModel.add(WebMvcLinkBuilder.linkTo(AccountController.class).slash("login").withRel("login"));
        entityModel.add(Link.of("/docs/index.html#signup").withRel("profile"));
        return ResponseEntity.ok(entityModel);
    }


    private static URI createUriWithResource(String resource) {
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(AccountController.class).slash(resource);
        return webMvcLinkBuilder.toUri();
    }

}
