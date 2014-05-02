package com.hamster.model;

import java.io.Serializable;

public enum ConfirmationErrorCodeTypeEnum implements ErrorCodeType {
    CONFIRMATION_DOES_NOT_EXIST,
    CONFIRAMTION_TYPE_IS_NOT_CORRECT,
    CONFIRMATION_STATE_IS_NOT_CORRECT,
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
