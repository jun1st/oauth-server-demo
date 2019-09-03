package me.fengqijun.oauthserverdemo.model;

public interface Entity<T extends EntityId> {
    T getId();
}
