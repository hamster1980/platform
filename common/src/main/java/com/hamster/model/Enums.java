package com.hamster.model;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Enums {

    private static ConcurrentMap<Enum<?>, Key> keys = new ConcurrentHashMap<>();
    
    private Enums(){
    }
    
    public static Key getKey(Enum<?> value){
        if(value == null){
            return null;
        }
        Key key = keys.get(value);
        if(key == null){
            //todo: use class name too
            keys.putIfAbsent(value, new StringKey(value.name()));
            key = keys.get(value);
        }
        return key;
    }
}
