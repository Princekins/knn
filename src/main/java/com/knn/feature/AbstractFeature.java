package com.knn.feature;

import com.knn.util.FeatureType;

/**
 * AbstractFeature
 *
 * @author Ian
 * @version 1.0
 */
public abstract class AbstractFeature<T> implements Feature<T> {
    private final FeatureType type;
    private final T value;

    protected AbstractFeature(FeatureType type, T value) {
        if (type == null || value == null)
            throw new IllegalArgumentException();
        this.type = type;
        this.value = value;
    }

    @Override
    public FeatureType type() {
        return type;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public double distanceTo(Feature<T> feature) {
        if (feature == null)
            return Double.MAX_VALUE;
        if (feature instanceof FeatureVector)
            return ((FeatureVector) feature).contains(type()) ? Math.abs(position() - ((FeatureVector) feature).get(type()).position()) : Double.MAX_VALUE;
        return Math.abs(position() - feature.position());
    }
}
