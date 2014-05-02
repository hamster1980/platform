package com.hamster.error;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.hamster.model.ErrorCodeType;
import com.hamster.rule.Rule;
import com.hamster.service.ErrorCodeService;

public class SimpleValidator<T, K extends ValidationDTO<T>> implements Validator<T, K>{

    @Autowired
    private ErrorCodeService errorCodeService;
    private Map<ErrorCodeType, Rule<K>> codes;
    
    public SimpleValidator(Map<ErrorCodeType, Rule<K>> codes) {
        this.codes = Preconditions.checkNotNull(codes);
    }

    @Override
    public T check(K dto) {
        Utils.throwErrorCodeException(errorCodeService, checkAndReturnErrorCode(dto));
        return dto.getReturnValue();
    }

    private ErrorCodeType checkAndReturnErrorCode(final K dto) {
        Entry<ErrorCodeType, Rule<K>> result = Iterables.find(
                codes.entrySet(), 
                new Predicate<Entry<ErrorCodeType, Rule<K>>>() {
                    @Override
                    public boolean apply(Entry<ErrorCodeType, Rule<K>> input) {
                        return input.getValue().isActual(dto);
                    }
                }
        );
        if(result != null) {
            return result.getKey();
        }
        return null;
    }

}
