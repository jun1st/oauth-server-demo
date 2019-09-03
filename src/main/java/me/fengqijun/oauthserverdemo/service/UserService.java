package me.fengqijun.oauthserverdemo.service;

import me.fengqijun.oauthserverdemo.model.User;

public interface UserService {
    User createOfficer(String email, String password);
}
