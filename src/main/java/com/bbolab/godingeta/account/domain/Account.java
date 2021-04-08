package com.bbolab.godingeta.account.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode(of = "id")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column
    private String username;

    @Column
    private String nickname;

    @Column(unique = true)
    private String email;

    @Column
    private String sns_id;

    @Column
    private String sns_type;

    @Column
    private String oauthId;

    @Column
    private String providerName;

    @Column
    private String accessToken;

    public Account(String oauthId, String name, String providerName, String accessToken) {
        this.oauthId = oauthId;
        this.username = name;
        this.providerName = providerName;
        this.accessToken = accessToken;
    }

}
