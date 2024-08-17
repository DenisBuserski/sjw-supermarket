package com.supermarket;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExceptionHandlerUtil {

    public static void handleConstraintViolationException(ConstraintViolationException e) {
        List<String> errorMessage = new ArrayList<>();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errorMessage.add("Error message: " + violation.getMessage());
        }

        errorMessage.forEach(log::error);
    }
}
