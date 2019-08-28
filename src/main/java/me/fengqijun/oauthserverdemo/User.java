package me.fengqijun.oauthserverdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@javax.persistence.Entity
@Table(name="oauthdemo_user")
public class User extends AbstractEntity<UserId>{

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);

        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
