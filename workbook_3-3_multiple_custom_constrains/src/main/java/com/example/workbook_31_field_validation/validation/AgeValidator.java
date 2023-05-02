package com.example.workbook_31_field_validation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AgeValidator implements ConstraintValidator<Age, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context){
        long diff = new Date().getTime() - date.getTime();
        int age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
        if (age < 18) {
            return false;
        }
        else{
            return true;
        }

    }

}
