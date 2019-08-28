package me.fengqijun.oauthserverdemo;

public interface Entity<T extends EntityId> {
    T getId();
}
