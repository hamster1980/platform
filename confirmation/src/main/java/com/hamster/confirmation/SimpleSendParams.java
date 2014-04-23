package com.hamster.confirmation;

import com.google.common.base.Objects;
import com.hamster.type.Type;

public class SimpleSendParams implements SendParams {

    private final long user;
    private final Type contactType;
    private final long entityId;

    public SimpleSendParams(long user, Type contactType, long entity) {
        this.user = user;
        this.contactType = contactType;
        this.entityId = entity;
    }
    
    @Override
    public long getUser() {
        return user;
    }

   @Override
    public Type getContactType() {
        return contactType;
    }

    @Override
    public long getEntityId() {
        return entityId;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("user", user)
                .add("contactType", contactType)
                .add("entityId", entityId)
                .toString();
    }

    
}
