package me.fengqijun.oauthserverdemo;

import me.fengqijun.oauthserverdemo.model.UniqueIdGenerator;
import me.fengqijun.oauthserverdemo.model.UniqueIdGeneratorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.UUID;

@SpringBootApplication
public class OauthServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerDemoApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    public UniqueIdGenerator<UUID> generator() {
        return new UniqueIdGeneratorImpl();
    }
}
