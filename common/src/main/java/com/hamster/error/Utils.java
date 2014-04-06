package com.hamster.error;

import com.hamster.model.ErrorCodeType;
import com.hamster.service.ErrorCodeService;

public class Utils {

    private Utils() {
    }

    public static void throwErrorCodeException(ErrorCodeService service,
            ErrorCodeType type) {
        throw new ErrorCodeException(service.getByType(type));
    }
}
