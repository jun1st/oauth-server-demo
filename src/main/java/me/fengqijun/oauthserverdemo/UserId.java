package me.fengqijun.oauthserverdemo;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID>{

    protected UserId() {

    }

    public UserId(UUID id) {
        super(id);
    }

}
