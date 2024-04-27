package com.example.commerce.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidPhoneNumber implements ConstraintValidator<ModifyPhoneValidation, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        if (phoneNumber == null) {
            return true;
        } else {
            String pattern = "^\\d{3}-\\d{4}-\\d{4}$";
            if (Pattern.matches(pattern, phoneNumber)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
