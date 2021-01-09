package com.bjartscular.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;

import java.io.IOException;

public class XmlProcessor {
    public <T> T parseWithCustomDeserializer(String text, Class<T> tClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new XmlFactory());

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Person.class, new PersonDeserializer());
        mapper.registerModule(module);

        return mapper.readValue(text, tClass);
    }

    public <T> T parse(String text, Class<T> tClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new XmlFactory());
        return mapper.readValue(text, tClass);
    }
}
