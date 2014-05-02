package com.hamster.service;

import com.hamster.confirmation.SendParams;
import com.hamster.model.Confirmation;
import com.hamster.state.State;

public interface ConfirmationService {

    Confirmation getConfirmationByCode(String code);
    
    Confirmation getConfirmationByCode(String code, String typeName);
    
    Confirmation getConfirmationByCode(String code, String typeName, State state);
    
    void create(SendParams params);
    
    void confirm(long id);
    
}
