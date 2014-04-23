package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.confirmation.SendParams;
import com.hamster.model.Confirmation;
import com.hamster.repository.ConfirmationRepository;

@Service("confirmationService")
@Transactional
public class ConfirmationServiceImpl implements ConfirmationService {

    @Autowired
    private ConfirmationRepository repository;

    @Override
    public Confirmation getConfirmationByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public void create(SendParams params) {
    }

}
