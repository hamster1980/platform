package com.hamster.model;

import java.util.Collection;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

public class Auth implements Persistable<Long>{

    private static final long serialVersionUID = 1L;
    
    private final long id;
    private final Person user;
    private AuthStateEnum state;
    private AuthPassword password;
    private Collection<AuthGrand> grands;
    private Collection<AuthRole> roles;
    
    public Auth(long id, Person user) {
        this.id = id;
        this.user = user;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public boolean isNew() {
        return id == 0;
    }

    public Person getUser() {
        return user;
    }

    public AuthStateEnum getState() {
        return state;
    }

    public void setState(AuthStateEnum state) {
        this.state = state;
    }

    public AuthPassword getPassword() {
        return password;
    }

    public void setPassword(AuthPassword password) {
        this.password = password;
    }

    public Collection<AuthGrand> getGrands() {
        return grands;
    }

    public void setGrands(Collection<AuthGrand> grands) {
        this.grands = grands;
    }

    public Collection<AuthRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AuthRole> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Auth && Objects.equal(((Auth) obj).id, id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("user", user)
                .add("state", state)
                .add("password", password)
                .add("grands", grands)
                .add("roles", roles)
                    .toString();
    }
    
}
