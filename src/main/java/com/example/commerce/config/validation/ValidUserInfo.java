package com.example.commerce.config.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUserInfo implements ConstraintValidator<ModifyUserInfoValidation, String> {
    @Override
    public boolean isValid(String info, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        if (info == null) {
            return true;
        } else {
            if (info.contains(" ")) {
                return false;
            } else {
                return true;
            }
        }
    }
}
