package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import com.hamster.type.Type;

public interface ErrorCodeType extends Type, Persistable<Serializable> {

}
