package com.hamster.model;

import java.io.Serializable;

public interface Persistable extends Serializable {

	Key getKey();
	
}
