package com.casabonita.spring.validations;

import com.casabonita.spring.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {

    @Autowired
    private User user;

    @Override
    public boolean supports(Class<?> userClass)
    {
        return User.class.equals(userClass);
    }

    @Override
    public void validate(Object object, Errors errors)
    {
        ValidationUtils.rejectIfEmpty(errors, "name", "name must be not null");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone must be not null");
        ValidationUtils.rejectIfEmpty(errors, "email", "the field does not match the template 'address@example.com'");

//        user = (User) object;
//
//        String regEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
//        if(Pattern.matches(regEmail, user.getEmail()))
//        {
//            errors.rejectValue("email", "email_does_not_match_the_template");
//        }
    }
}
