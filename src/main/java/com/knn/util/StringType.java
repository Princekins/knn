package com.knn.util;

/**
 * StringType
 *
 * @author Ian Caffey
 * @version 1.0
 */
public class StringType implements FeatureType {
    private final String name;

    public StringType(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public int hashCode() {
        return 31 + name().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof StringType && name().equals(((StringType) o).name());
    }
}
