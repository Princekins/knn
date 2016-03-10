package com.knn.feature;

import com.knn.util.FeatureType;

/**
 * NumericFeature
 *
 * @author Ian Caffey
 * @version 1.0
 */
public class NumericFeature<T extends Number> extends AbstractFeature<T> {
    public NumericFeature(FeatureType type, T value) {
        super(type, value);
        if (type == null || value == null)
            throw new IllegalArgumentException();
    }

    @Override
    public double position() {
        return value().doubleValue();
    }
}
