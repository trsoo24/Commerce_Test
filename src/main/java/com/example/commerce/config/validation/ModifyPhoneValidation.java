package com.example.commerce.config.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidPhoneNumber.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModifyPhoneValidation {
    String message() default "올바르지 않은 전화번호 양식입니다. 010-1234-1234";
}
