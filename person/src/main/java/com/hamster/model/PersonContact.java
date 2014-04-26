package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;
import com.hamster.state.State;
import com.hamster.state.Stateable;
import com.hamster.type.Type;
import com.hamster.type.Typeable;

@Entity
@Table(name = "PERSON_CONTACT")
public class PersonContact implements Stateable, Typeable, Persistable<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private final long key;
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_ID")
    private PersonContactTypeEnum type;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE_ID")
    private PersonContactStateEnum state;
    @Column(name = "CONTACT")
    private String value;
    @Column(name = "MAIN")
    private boolean main;

    public PersonContact() {
        this(0);
    }

    public PersonContact(long key) {
        this.key = key;
    }

    @Override
    public Long getId() {
        return key;
    }

    @Override
    public boolean isNew() {
        return key == 0;
    }

    public Person getPerson() {
        return person;
    }

    public void setPersonKey(Person person) {
        this.person = person;
    }

    @Override
    public Type getType() {
        return type;
    }

    public void setType(PersonContactTypeEnum type) {
        this.type = type;
    }

    @Override
    public State getState() {
        return state;
    }

    public void setState(PersonContactStateEnum state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PersonContact
                && Objects.equal(((PersonContact) obj).key, key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("key", key)
                .add("person", person).add("type", type)
                .add("state", state).add("value", value).add("main", main)
                .toString();
    }

}
