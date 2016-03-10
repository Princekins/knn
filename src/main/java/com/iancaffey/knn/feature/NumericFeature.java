package com.iancaffey.knn.feature;

import com.iancaffey.knn.util.FeatureType;

/**
 * NumericFeature
 *
 * @author Ian Caffey
 * @since 1.0
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
