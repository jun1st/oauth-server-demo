package me.fengqijun.oauthserverdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


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

    public static User createOfficer(UserId userId, String email, String password) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);

        User user = new User(userId, email, password, roles);
        return user;
    }

    public static User createCaptain(UserId userId, String email, String password) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.CAPTAIN);

        User user = new User(userId, email, password, roles);
        return user;
    }
}
