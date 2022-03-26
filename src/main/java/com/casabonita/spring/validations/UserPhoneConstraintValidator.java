package com.casabonita.spring.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UserPhoneConstraintValidator implements ConstraintValidator<MyOwnPhoneConstraint, String>
{
    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext)
    {
        String regPhone = "^((\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10}$";
        if(Pattern.matches(regPhone, phone))
        {
            return true;
        }
        return false;
    }
}
