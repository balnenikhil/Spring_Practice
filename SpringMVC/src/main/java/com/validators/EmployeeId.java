package com.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmployeeIdConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeId {
    //code for value

    public String value() default "ZTP";

    //code for error message

    public String message() default "Employee Id Not Valid, Id Starts With ZTP";

    //code for default groups
    public Class<?> [] groups() default{};

    //code for default payloads
    public Class<? extends Payload>[] payload() default{};

}
