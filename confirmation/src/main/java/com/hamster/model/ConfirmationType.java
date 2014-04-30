package com.hamster.model;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;
import com.hamster.type.Type;

public class ConfirmationType implements Persistable<Long>, Type {

    private static final long serialVersionUID = 1L;
    
    private final long id;
    private String name;
    private String templateForSending;
    private String templateForResending;

    public ConfirmationType() {
        this(0);
    }
    
    public ConfirmationType(long id) {
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

    public String getTemplateForSending() {
        return templateForSending;
    }

    public void setTemplateForSending(String templateForSending) {
        this.templateForSending = templateForSending;
    }

    public String getTemplateForResending() {
        return templateForResending;
    }

    public void setTemplateForResending(String templateForResending) {
        this.templateForResending = templateForResending;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ConfirmationType && Objects.equal(((ConfirmationType) obj).id, id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("templateForSending", templateForSending)
                .add("templateForResending", templateForResending)
                    .toString();
    }

}
