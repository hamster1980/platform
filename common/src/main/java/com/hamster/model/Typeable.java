package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

public interface Typeable<ID extends Serializable> extends Persistable<ID> {

	Type getType();
	
}
