package com.example.commerce.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidEmail implements ConstraintValidator<ModifyEmailValidation, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        // 커스텀 메시지를 위해 기본 메시지 disable
        constraintValidatorContext.disableDefaultConstraintViolation();

        if (email == null) {
            return true;
        } else {
            String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
            if (Pattern.matches(pattern, email)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
