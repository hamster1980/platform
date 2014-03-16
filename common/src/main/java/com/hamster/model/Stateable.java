package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

public interface Stateable<ID extends Serializable> extends Persistable<ID> {

	State getState();
	
}
