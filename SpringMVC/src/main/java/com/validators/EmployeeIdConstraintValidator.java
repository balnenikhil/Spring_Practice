package com.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeIdConstraintValidator implements ConstraintValidator<EmployeeId, String> {
    private String idPrefix;

    @Override
    public void initialize(EmployeeId id) {
        idPrefix =id.value();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean result ;
        if(id != null){
            result=id.startsWith(idPrefix);
        }
        else{result = true;}

        return result;
    }
}
