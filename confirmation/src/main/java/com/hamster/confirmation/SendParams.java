package com.hamster.confirmation;

import com.hamster.type.Type;

public interface SendParams {

    long getUser();
    
    Type getContactType();
    
    long getEntityId();
    
    String getTypeName();
    
}
