package com.xcoder.data.store.config;

import java.util.Objects;

import lombok.Setter;

public class KeyHelper {
    private static final String DEFAULT_PREFIX = "app";
    @Setter
    private static String prefix = null;

    public static String getKey(String key) {
        return getPrefix() + ":" + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(prefix, DEFAULT_PREFIX);
    }
}
