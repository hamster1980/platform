package com.hamster.error;

import org.springframework.context.MessageSourceResolvable;

public class ApplicationException extends RuntimeException implements MessageSourceResolvable {

    private static final long serialVersionUID = 1L;

    private final String[] params;

    public ApplicationException(String message) {
        this(message, null);
    }

    public ApplicationException(String message, String... params) {
        super(message);
        this.params = params;
    }

    @Override
    public String[] getCodes() {
        return new String[] { getCode() };
    }

    @Override
    public Object[] getArguments() {
        return params;
    }

    @Override
    public String getDefaultMessage() {
        return "Undefind error. Please write about problem to support service";
    }

    public String getCode(){
        return "error.undefind";
    }

}
