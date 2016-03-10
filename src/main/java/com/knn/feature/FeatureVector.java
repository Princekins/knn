package com.knn.feature;

import com.knn.util.FeatureType;
import com.knn.util.Features;

/**
 * FeatureVector
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FeatureVector<T> extends AbstractFeature<T> {
    private final FeatureSet features;

    public FeatureVector(FeatureType type, T value) {
        this(type, value, new FeatureSet());
    }

    public FeatureVector(FeatureType type, T value, FeatureSet features) {
        super(type, value);
        if (features == null)
            throw new IllegalArgumentException();
        this.features = features;
    }

    public FeatureSet features() {
        return features;
    }

    @Override
    public double position() {
        return features().contains(type()) ? features().get(type()).position() : 0;
    }

    @Override
    public double distanceTo(Feature<T> feature) {
        return Features.distance(features(), feature);
    }
}
