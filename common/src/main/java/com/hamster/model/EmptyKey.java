package com.hamster.model;

import com.google.common.base.Objects;

public class EmptyKey implements Key {

	private static final long serialVersionUID = 1L;

	public static final EmptyKey DEFAULT = new EmptyKey();
	
	@Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EmptyKey;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
    

}
