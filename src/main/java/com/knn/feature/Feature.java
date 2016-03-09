package com.knn.feature;

import com.knn.util.FeatureType;

/**
 * Feature
 *
 * @author Ian
 * @version 1.0
 */
public interface Feature<T> {
    public FeatureType type();

    public T value();

    public double position();

    public double distanceTo(Feature<T> feature);
}