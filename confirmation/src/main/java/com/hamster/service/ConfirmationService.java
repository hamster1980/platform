package com.hamster.service;

import com.hamster.confirmation.SendParams;
import com.hamster.model.Confirmation;

public interface ConfirmationService {

    Confirmation getConfirmationByCode(String code);
    
    void send(SendParams params);
    
}
