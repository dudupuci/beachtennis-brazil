package br.com.beachtennisbrazil.api.app.entities.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter(autoApply = true)
public class ArrayJsonConverter implements AttributeConverter<Set, String> {

    static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set list) {
        if (list == null)
            return null;
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Set convertToEntityAttribute(String dbJson) {
        if (dbJson == null)
            return null;
        try {
            return mapper.readValue(dbJson, new TypeReference<Set<String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}