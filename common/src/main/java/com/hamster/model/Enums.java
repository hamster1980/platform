package com.hamster.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.google.common.base.Optional;

public class Enums {

    private static ConcurrentMap<Enum<?>, Serializable> keys = new ConcurrentHashMap<>();

    private Enums() {
    }

    public static Serializable getKey(Enum<?> value) {
        if (value == null) {
            return null;
        }
        Serializable key = keys.get(value);
        if (key == null) {
            // todo: use class name too
            keys.putIfAbsent(value, value.name());
            key = keys.get(value);
        }
        return key;
    }

    public static String getStringValue(Enum<?> value) {
        return value != null ? value.name() : null;
    }

    public static <T extends Enum<T>> T findValueByStringValue(
            Class<T> enumClass, String value) {
        Optional<T> optional = com.google.common.base.Enums.getIfPresent(
                enumClass, value);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
