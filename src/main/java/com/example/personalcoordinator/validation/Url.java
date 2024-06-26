package com.example.personalcoordinator.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UrlValidator.class)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {
    String message() default "Invalid URL for Cover Image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
