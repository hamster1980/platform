package com.hamster.error;

import com.hamster.rule.DTO;

public interface ValidationDTO<T> extends DTO {

    T getReturnValue();
    
}
