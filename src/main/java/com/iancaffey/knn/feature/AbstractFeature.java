package com.iancaffey.knn.feature;

import com.iancaffey.knn.lang.DimensionException;
import com.iancaffey.knn.util.FeatureType;

import java.util.Objects;

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
        if (feature instanceof FeatureVector) {
            if (!((FeatureVector) feature).features().contains(type()))
                throw new DimensionException(type, feature.type());
            return distanceTo(((FeatureVector) feature).features().get(type()).position());
        }
        if (!Objects.equals(type(), feature.type()))
            throw new DimensionException(type, feature.type());
        return distanceTo(feature.position());
    }
}
