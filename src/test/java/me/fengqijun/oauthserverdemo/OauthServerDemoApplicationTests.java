package me.fengqijun.oauthserverdemo;

import me.fengqijun.oauthserverdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringProperties;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OauthServerDemoApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Test
    public void testGetAccessTokenAsOfficer() throws Exception {
        userService.createOfficer(Users.OFFICER_EMAIL, Users.OFFICER_PASSWORD);

        String clientId = "oauth-demo";
        String clientSecret = "thisistestpassword";

        MultiValueMap<String, String> params =
                new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);

        params.add("username", Users.OFFICER_EMAIL);
        params.add("password", Users.OFFICER_PASSWORD);

        mvc.perform(post("/oauth/token")
                    .params(params)
                    .with(httpBasic(clientId, clientSecret))
                    .accept("application/json;chartset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andExpect(jsonPath("access_token").isString())
                .andExpect(jsonPath("token_type").isString())
                .andExpect(jsonPath("refresh_token").isString())
                .andExpect(jsonPath("expires_in").isNumber())
                .andExpect(jsonPath("scope").value("mobile_app"));
    }
}
