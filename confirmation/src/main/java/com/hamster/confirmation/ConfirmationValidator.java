package com.hamster.confirmation;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;
import com.hamster.error.SimpleValidator;
import com.hamster.model.Confirmation;
import com.hamster.model.ConfirmationErrorCodeTypeEnum;
import com.hamster.model.ErrorCodeType;
import com.hamster.rule.Rule;

@Component("confirmationValidator")
public class ConfirmationValidator extends SimpleValidator<Confirmation, ConfirmationValidationDTO> {

    public ConfirmationValidator() {
        super(new ImmutableMap.Builder<ErrorCodeType, Rule<ConfirmationValidationDTO>>()
                .put(ConfirmationErrorCodeTypeEnum.CONFIRMATION_DOES_NOT_EXIST,
                        new Rule<ConfirmationValidationDTO>() {
                            @Override
                            public boolean isActual(ConfirmationValidationDTO dto) {
                                return dto.getConfirmation() == null;
                            }
                        }
                ).put(ConfirmationErrorCodeTypeEnum.CONFIRAMTION_TYPE_IS_NOT_CORRECT,
                        new Rule<ConfirmationValidationDTO>() {
                            @Override
                            public boolean isActual(ConfirmationValidationDTO dto) {
                                return dto.getTypeName() != null && (dto.getConfirmation().getType() == null || !dto.getTypeName().equals(dto.getConfirmation().getType().getName()));
                            }
                        }
                ).put(ConfirmationErrorCodeTypeEnum.CONFIRMATION_STATE_IS_NOT_CORRECT,
                        new Rule<ConfirmationValidationDTO>() {
                            @Override
                            public boolean isActual(ConfirmationValidationDTO dto) {
                                return dto.getState() != null && (dto.getState().equals(dto.getConfirmation().getState()));
                            }
                        }
                ).build()
        );
    }
    
}
