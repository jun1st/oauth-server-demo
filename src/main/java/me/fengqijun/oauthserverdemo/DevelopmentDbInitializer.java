package me.fengqijun.oauthserverdemo;

import me.fengqijun.oauthserverdemo.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevelopmentDbInitializer implements ApplicationRunner {

    private final UserService userService;

    public DevelopmentDbInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createTestUsers();
    }

    private void createTestUsers() {
        userService.createOfficer("officer@example.com", "officer");
    }
}
