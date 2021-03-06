package com.iancaffey.knn.feature;

import com.iancaffey.knn.util.FeatureType;

/**
 * Feature
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Feature<T> {
    public FeatureType type();

    public T value();

    public double position();

    public double distanceTo(double position);

    public double distanceTo(Feature<T> feature);
}
