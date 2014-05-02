package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.confirmation.ConfirmationValidationDTO;
import com.hamster.confirmation.SendParams;
import com.hamster.error.Validator;
import com.hamster.model.Confirmation;
import com.hamster.model.ConfirmationStateEnum;
import com.hamster.repository.ConfirmationRepository;
import com.hamster.state.State;

@Service("confirmationService")
@Transactional
public class ConfirmationServiceImpl implements ConfirmationService {

    @Autowired
    private ConfirmationRepository repository;
    @Autowired
    @Qualifier("confirmationValidator")
    private Validator<Confirmation, ConfirmationValidationDTO> validator;
    
    @Override
    public Confirmation getConfirmationByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Confirmation getConfirmationByCode(String code, String typeName) {
        return getConfirmationByCode(code, typeName, ConfirmationStateEnum.CREATED);
    }

    @Override
    //todo: test
    public Confirmation getConfirmationByCode(String code, String typeName, State state) {
        return validator.check(new ConfirmationValidationDTO(getConfirmationByCode(code), typeName, state));
    }
    
    @Override
    public void create(SendParams params) {
        //todo: implement
    }

    @Override
    public void confirm(long id) {
        Confirmation c = repository.getOne(id);  
        //todo: validate
        c.setState(ConfirmationStateEnum.CONFIRMED);
        repository.saveAndFlush(c);
    }

}
