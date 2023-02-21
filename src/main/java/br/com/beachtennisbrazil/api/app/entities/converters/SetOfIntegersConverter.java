package br.com.beachtennisbrazil.api.app.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class SetOfIntegersConverter implements AttributeConverter<List<Integer>, String> {
    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<Integer> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        return set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPLIT_CHAR));
    }

    @Override
    public List<Integer> convertToEntityAttribute(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(str.split(SPLIT_CHAR))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
