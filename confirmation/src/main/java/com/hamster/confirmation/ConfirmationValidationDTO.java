package com.hamster.confirmation;

import com.hamster.error.ValidationDTO;
import com.hamster.model.Confirmation;
import com.hamster.state.State;

public class ConfirmationValidationDTO implements ValidationDTO<Confirmation> {

    private static final long serialVersionUID = 1L;

    private final Confirmation confirmation;
    private final String typeName;
    private final State state;

    public ConfirmationValidationDTO(Confirmation confirmation, String typeName, State state) {
        this.confirmation = confirmation;
        this.typeName = typeName;
        this.state = state;
    }

    @Override
    public Confirmation getReturnValue() {
        return getConfirmation();
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }

    public String getTypeName() {
        return typeName;
    }

    public State getState() {
        return state;
    }
    
}
