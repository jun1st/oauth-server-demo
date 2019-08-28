package me.fengqijun.oauthserverdemo;

import java.util.UUID;

public class UniqueIdGeneratorImpl implements UniqueIdGenerator<UUID>
{
    @Override
    public UUID getNextUniqueId() {
        return UUID.randomUUID();
    }
}
