package com.bjartscular.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class PersonDeserializer extends StdDeserializer<Person> {
    public PersonDeserializer() {
        this(null);
    }

    public PersonDeserializer(Class<?> valueType) {
        super(valueType);
    }

    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Person person = new Person();

        if (node.has("id")) {
//            id = node.get("id").asText();
            person.setId(node.get("id").asText());
        }

        // Support XML
        if (node.has("")) {
//            name = node.get("").asText();
            person.setName(node.get("").asText());

            // Support JSON
        } else if (node.has("value")) {
//            name = node.get("value").asText();
            person.setName(node.get("value").asText());
        }

        return person;
    }
}
