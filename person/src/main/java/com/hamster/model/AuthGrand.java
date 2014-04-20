package com.hamster.model;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

public class AuthGrand implements Persistable<Long>{

    private static final long serialVersionUID = 1L;
    
    private final long id;
    private String name;
    private String description;
    
    public AuthGrand(long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AuthGrand && Objects.equal(((AuthGrand) obj).id, id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("description", description)
                    .toString();
    }

}
