package com.hamster.error;

import com.hamster.model.ErrorCodeType;
import com.hamster.test.Utils.InvocationCallback;
import com.hamster.test.Utils.SimpleExceptionCallback;

public class ErrorCodeExceptionCallback extends SimpleExceptionCallback {

    private ErrorCodeType errorType;
    
    public ErrorCodeExceptionCallback(InvocationCallback callback, ErrorCodeType errorType) {
        super(callback);
        this.errorType = errorType;
    }

    @Override
    public boolean check(Exception e) {
        return errorType == null 
                || (e instanceof ErrorCodeException 
                        && ((ErrorCodeException)e).getError().getType().equals(errorType.toString()));
    }

}
