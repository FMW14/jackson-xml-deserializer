package com.bjartscular.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DeserializationTest {
    private final String xmlString = "<person id=\"1\">John</person>";
    private final XmlProcessor xmlProcessor = new XmlProcessor();

    @Test
    public void useCustomDeserializer() throws IOException {
        Person person = xmlProcessor.parseWithCustomDeserializer(xmlString, Person.class);
        System.out.println(person);
    }

    @Test
    public void defaultDeserializer() throws IOException {
        Person person = xmlProcessor.parse(xmlString, Person.class);
        System.out.println(person);
    }
}
