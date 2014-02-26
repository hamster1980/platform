package com.hamster.error;

import org.springframework.context.MessageSourceResolvable;

public class InternalException extends RuntimeException implements MessageSourceResolvable {

    private static final long serialVersionUID = 1L;

    private final String[] params;

    public InternalException(Throwable cause) {
        this(null, cause);
    }

    public InternalException(String[] params, Throwable cause) {
        super(cause);
        this.params = params;
    }

    public String[] getCodes() {
        return new String[] { "application.core.error.undefind" };
    }

    public Object[] getArguments() {
        return params;
    }

    public String getDefaultMessage() {
        return "Undefind error. Please write about problem to support service";
    }

}
