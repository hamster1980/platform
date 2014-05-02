package com.hamster.error;

public interface Validator<T, K extends ValidationDTO<T>> {

    T check(K dto);
    
}
