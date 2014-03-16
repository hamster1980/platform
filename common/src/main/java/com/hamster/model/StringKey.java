package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

@Embeddable
public class StringKey implements Key, Comparable<StringKey> {

	private static final long serialVersionUID = 1L;
	
	public static StringKey EMPTY_KEY = new StringKey();
	
	@Column(name="ID")
	private final String value;

	public StringKey() {
		this(StringUtils.EMPTY);
	}
	
	public StringKey(String value) {
		this.value = Preconditions.checkNotNull(value);
	}

	public String getValue() {
		return value;
	}

    @Override
    public int compareTo(StringKey o) {
        return value.compareTo(o.getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StringKey
                && ((StringKey)obj).value.equals(value);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).addValue(value).toString();
    }
    
	
}
