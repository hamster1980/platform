package com.hamster.confirmation;

import java.io.Serializable;

public interface ConfirmParams extends Serializable {

    long getUser();
    
    String getCode();

}
