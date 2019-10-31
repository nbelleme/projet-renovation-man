package io.belleme.renovation.model.converter;

import io.belleme.renovation.model.Intitule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class IntituleConverter implements AttributeConverter<Intitule, String> {
    @Override
    public String convertToDatabaseColumn(Intitule intitule) {
        Objects.requireNonNull(intitule);
        return intitule.getValue();
    }

    @Override
    public Intitule convertToEntityAttribute(String s) {
        Objects.requireNonNull(s);
        return new Intitule(s);
    }
}
