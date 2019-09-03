package me.fengqijun.oauthserverdemo.service;

import me.fengqijun.oauthserverdemo.model.User;
import me.fengqijun.oauthserverdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmailIgnoreCase(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s could not be found", s)));

        return new ApplicationUserDetails(user);
    }
}
