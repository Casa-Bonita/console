package com.casabonita.spring.deserializers;

import com.casabonita.spring.dto.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс реализующий логику считывания данных из НЕ стандартного JSON-файла (когда присутствуют 2 поля) - 2-й вариант
 */
public class JsonCustomDeserializer_2 extends StdDeserializer<User> {

    @Autowired
    private User user;

    public JsonCustomDeserializer_2()
    {
        this(null);
    }

    public JsonCustomDeserializer_2(Class<?> jcd)
    {
        super(jcd);
    }

    /**
     * Метод отвечающий за считывание данных из НЕ стандартного JSON-файла (когда присутствуют 2 поля) - 2-й вариант
     * @param parser считывает содержимое JSON-файла
     * @param deserializer контекст для процесса десериализации
     * @return объект типа User
     * @throws IOException
     */
    @Override
    public User deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException
    {
        TreeNode treeNode = parser.readValueAsTree();
        Iterator<String> jsonFields = treeNode.fieldNames();
        while (jsonFields.hasNext()) {
            String field = jsonFields.next();
            String fieldValue = treeNode.get(field).toString();
            switch(field) {
                case "name":
                    user.setName(fieldValue);
                    break;
                case "phone":
                    user.setPhone(fieldValue);
                    break;
                case "email":
                    user.setEmail(fieldValue);
                    break;
            }
        }

        return user;
    }
}
