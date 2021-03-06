package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import com.hamster.type.Type;

public enum PersonContactTypeEnum implements Type, Persistable<Serializable> {
    EMAIL, 
    PHONE, 
    ;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
