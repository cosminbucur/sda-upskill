package com.sda.json;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

class JsonSchemaTest {

    @Test
    void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(getClass().getResourceAsStream("/schema/ComplexSchema.json")));
        JSONObject jsonObject = new JSONObject(
                new JSONTokener(getClass().getResourceAsStream("/json/valid.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonObject);
    }
}
