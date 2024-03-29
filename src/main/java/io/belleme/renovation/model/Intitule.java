package io.belleme.renovation.model;

public class Intitule {
    private String value;

    public Intitule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Intitule intitule = (Intitule) o;

        return value != null ? value.equals(intitule.value) : intitule.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
