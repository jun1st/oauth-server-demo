package me.fengqijun.oauthserverdemo.repository;

import me.fengqijun.oauthserverdemo.model.UniqueIdGenerator;
import me.fengqijun.oauthserverdemo.model.UserId;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;


    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public UserId nextId() {
        return new UserId(generator.getNextUniqueId());
    }
}
