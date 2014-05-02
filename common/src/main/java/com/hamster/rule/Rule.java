package com.hamster.rule;

public interface Rule<K extends DTO> {

    boolean isActual(K dto);
    
}
