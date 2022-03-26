package com.casabonita.spring;

import com.casabonita.spring.deserializers.JsonCustomDeserializer_1;
import com.casabonita.spring.deserializers.JsonCustomDeserializer_2;
import com.casabonita.spring.dto.User;
import com.casabonita.spring.deserializers.JsonDeserializer;
import com.casabonita.spring.pathsAndDirectories.MakePath;
import com.casabonita.spring.validations.UserValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Config {

    @Autowired
    private User user;

    public static void work() throws IOException{
        MakePath makePath = new MakePath();
        List<String> paths = makePath.createPath();

        JsonDeserializer jsonDeserializer = new JsonDeserializer();

        ObjectMapper objectMapper_1 = new ObjectMapper();
        SimpleModule simpleModule_1 = new SimpleModule();
        simpleModule_1.addDeserializer(User.class, new JsonCustomDeserializer_1());
        objectMapper_1.registerModule(simpleModule_1);

        ObjectMapper objectMapper_2 = new ObjectMapper();
        SimpleModule simpleModule_2 = new SimpleModule();
        simpleModule_2.addDeserializer(User.class, new JsonCustomDeserializer_2());
        objectMapper_2.registerModule(simpleModule_2);

        Map<Integer, User> mapUsual = new HashMap<>();
        Map<Integer, User> mapCustom_1 = new HashMap<>();
        Map<Integer, User> mapCustom_2 = new HashMap<>();

        for (int i = 0; i < paths.size(); i++) {
            User userUsual = jsonDeserializer.readJson(paths.get(i));
            mapUsual.put(i, userUsual);

            User userCustom_1 = objectMapper_1.readValue(new File(paths.get(i)), User.class);
            mapCustom_1.put(i, userCustom_1);

            User userCustom_2 = objectMapper_2.readValue(new File(paths.get(i)), User.class);
            mapCustom_2.put(i, userCustom_2);
        }
    }
}