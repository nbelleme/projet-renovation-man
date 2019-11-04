package io.belleme.renovation.model;


import io.belleme.renovation.model.exception.IncorrectEmailFormatException;
import io.belleme.renovation.model.exception.NullOrEmptyValueException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern REGEX_MAIL = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+\\=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    private String value;

    public Email(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void validate() {
        if (StringUtils.isEmpty(value)) {
            throw new NullOrEmptyValueException();
        }

        Matcher m = REGEX_MAIL.matcher(value);
        if (!m.find()) {
            throw new IncorrectEmailFormatException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return value != null ? value.equals(email.value) : email.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
