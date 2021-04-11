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

    @Column
    private String password;

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

    @Column
    private String picture;

    private Account(String name, String email, String picture){
        this.username = name;
        this.email = email;
        this.picture = picture;
    }

    // TODO : Use Factory pattern
    public Account(String oauthId, String name, String providerName, String accessToken) {
        this.oauthId = oauthId;
        this.username = name;
        this.providerName = providerName;
        this.accessToken = accessToken;
    }

    public static Account of(String name, String email, String picture) {
        return new Account(name, email, picture);
    }

    public Account update(String name, String picture) {
        this.username = name;
        this.picture = picture;
        return this;
    }
}
