package com.iancaffey.knn.feature;

import com.iancaffey.knn.util.FeatureType;

/**
 * AbstractFeature
 *
 * @author Ian Caffey
 * @since 1.0
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
    public double distanceTo(double position) {
        return Math.abs(position() - position);
    }

    @Override
    public double distanceTo(Feature<T> feature) {
        if (feature == null)
            return Double.MAX_VALUE;
        if (feature instanceof FeatureVector)
            return ((FeatureVector) feature).features().contains(type()) ? distanceTo(((FeatureVector) feature).features().get(type()).position()) : Double.MAX_VALUE;
        return distanceTo(feature.position());
    }
}
