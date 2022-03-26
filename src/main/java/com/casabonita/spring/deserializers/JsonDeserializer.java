package com.casabonita.spring.deserializers;

import com.casabonita.spring.dto.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

/**
 * Класс реализующий логику считывания данных из СТАНДАРТНОГО JSON-файла (когда присутствуют все 3 поля)
 */
@NoArgsConstructor
@AllArgsConstructor
public class JsonDeserializer {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Метод отвечающий за считывание данных из СТАНДАРТНОГО JSON-файла (когда присутствуют все 3 поля)
     * @param path - ссылка на местонахождение JSON-файлов
     * @return - объект типа User
     * @throws IOException
     */
    public User readJson(String path) throws IOException
    {
        User user = null;

        try
        {
            user = objectMapper.readValue(new File(path), User.class);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

        return user;
    }
}