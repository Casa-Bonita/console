package com.casabonita.spring;

import com.casabonita.spring.dto.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {



        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.casabonita.spring");
        User user = context.getBean("userBean", User.class);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        for(ConstraintViolation<User> temp : constraintViolations)
        {
            System.out.println(temp.getMessage());
        }

        Config.work();

        context.close();
    }
}
