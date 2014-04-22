package com.hamster.model;

import org.joda.time.DateTime;
import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;
import com.hamster.state.Stateable;

public class Confirmation implements Persistable<Long>, Stateable{

    private static final long serialVersionUID = 1L;
    
    private final long id;
    private String code;
    private Person user;
    private PersonContact contact;
    private long entityId;
    private ConfirmationStateEnum state;
    private DateTime lastSendingDate;
    
    public Confirmation() {
        this(0);
    }
    
    public Confirmation(long id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public PersonContact getContact() {
        return contact;
    }

    public void setContact(PersonContact contact) {
        this.contact = contact;
    }

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }
    
    @Override
    public ConfirmationStateEnum getState() {
        return state;
    }

    public void setState(ConfirmationStateEnum state) {
        this.state = state;
    }

    public DateTime getLastSendingDate() {
        return lastSendingDate;
    }

    public void setLastSendingDate(DateTime lastSendingDate) {
        this.lastSendingDate = lastSendingDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Confirmation && Objects.equal(((Confirmation) obj).id, id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("code", code)
                .add("entity", entityId)
                .add("user", user)
                .add("contact", contact)
                    .toString();
    }
    
}
