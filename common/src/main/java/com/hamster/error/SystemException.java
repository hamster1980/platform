package com.hamster.error;

import org.springframework.context.MessageSourceResolvable;

public class SystemException extends RuntimeException implements
        MessageSourceResolvable {

    private static final long serialVersionUID = 1L;

    protected SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public String[] getCodes() {
        return new String[] { "application.core.error.system" };
    }

    public Object[] getArguments() {
        return null;
    }

    public String getDefaultMessage() {
        return "System error. Please write about problem to support service";
    }

}
