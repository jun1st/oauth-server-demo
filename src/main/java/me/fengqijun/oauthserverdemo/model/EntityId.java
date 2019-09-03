package me.fengqijun.oauthserverdemo.model;

import java.io.Serializable;

public interface EntityId<T> extends Serializable {

    T getId();

    String asString();
}
