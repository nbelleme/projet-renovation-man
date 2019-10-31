package io.belleme.renovation.model.converter;

import io.belleme.renovation.model.Email;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class EmailConverter implements AttributeConverter<Email, String> {


    @Override
    public String convertToDatabaseColumn(Email email) {
        Objects.requireNonNull(email);
        return email.getValue();
    }

    @Override
    public Email convertToEntityAttribute(String s) {
        Objects.requireNonNull(s);
        return new Email(s);
    }
}
