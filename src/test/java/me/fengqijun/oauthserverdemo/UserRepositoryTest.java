package me.fengqijun.oauthserverdemo;

import me.fengqijun.oauthserverdemo.model.UniqueIdGenerator;
import me.fengqijun.oauthserverdemo.model.UniqueIdGeneratorImpl;
import me.fengqijun.oauthserverdemo.model.User;
import me.fengqijun.oauthserverdemo.model.UserRole;
import me.fengqijun.oauthserverdemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);

        User user = repository.save(new User(repository.nextId(), "test@example.com", "decret-password", roles));

        System.out.println(user.getId().asString());
        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }

    @Test
    public void testFindByEmail() {
//        User user = Users.re
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> generator() {
            return new UniqueIdGeneratorImpl();
        }

    }
}
