package com.hamster.model;

import org.joda.time.DateTime;
import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

public class AuthPassword implements Persistable<Long> {

    private static final long serialVersionUID = 1L;
    
    private final long id;
    private String codedValue;
    private DateTime lastChangedDate;
    private DateTime expirationDate;

    public AuthPassword(long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == 0;
    }

    public String getCodedValue() {
        return codedValue;
    }

    public void setCodedValue(String codedValue) {
        this.codedValue = codedValue;
    }

    public DateTime getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(DateTime lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

    public DateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AuthPassword && Objects.equal(((AuthPassword) obj).id, id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("lastChangedDate", lastChangedDate)
                .add("expirationDate", expirationDate)
                    .toString();
    }

}
