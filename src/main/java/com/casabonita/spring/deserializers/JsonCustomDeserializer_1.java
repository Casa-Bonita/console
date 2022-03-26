package com.casabonita.spring.deserializers;

import com.casabonita.spring.dto.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Класс реализующий логику считывания данных из НЕ стандартного JSON-файла (когда присутствуют 2 поля) - 1-й вариант
 */
public class JsonCustomDeserializer_1 extends StdDeserializer<User>{

    @Autowired
    private User user;

    public JsonCustomDeserializer_1()
    {
        this(null);
    }

    public JsonCustomDeserializer_1(Class<?> jcd)
    {
        super(jcd);
    }

    /**
     * Метод отвечающий за считывание данных из НЕ стандартного JSON-файла (когда присутствуют 2 поля) - 1-й вариант
     * @param parser считывает содержимое JSON-файла
     * @param deserializer контекст для процесса десериализации
     * @return объект типа User
     * @throws IOException
     */
    @Override
    public User deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException
    {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        try
        {
            JsonNode nameNode = node.get("name");
            String name = nameNode.asText();
            user.setName(name);

            JsonNode phoneNode = node.get("phone");
            String phone = phoneNode.asText();
            user.setPhone(phone);

            JsonNode emailNode = node.get("email");
            String email = emailNode.asText();
            user.setEmail(email);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return user;
    }
}
