package com.knn.feature;

import com.knn.util.FeatureType;

import java.util.HashMap;
import java.util.Map;

/**
 * FeatureVector
 *
 * @author Ian
 * @version 1.0
 */
public class FeatureVector<T> extends AbstractFeature<T> {
    private final Map<FeatureType, Feature<?>> features = new HashMap<>();

    public FeatureVector(FeatureType type, T value) {
        super(type, value);
    }

    public FeatureVector<T> set(FeatureType type, Feature<?> feature) {
        if (type == null || feature == null)
            throw new IllegalArgumentException();
        features.put(type, feature);
        return this;
    }

    public <T> Feature<T> get(FeatureType type) {
        return (Feature<T>) features.get(type);
    }

    public boolean contains(FeatureType type) {
        return features.containsKey(type);
    }

    @Override
    public double position() {
        return contains(type()) ? get(type()).position() : 0;
    }

    @Override
    public double distanceTo(Feature<T> feature) {
        if (!(feature instanceof FeatureVector))
            return contains(feature.type()) ? this.<T>get(feature.type()).distanceTo(feature) : Double.MAX_VALUE;
        FeatureVector<T> vector = (FeatureVector<T>) feature;
        double sum = 0.0;
        for (Map.Entry<FeatureType, Feature<?>> entry : features.entrySet())
            if (vector.contains(entry.getKey()))
                sum += entry.getValue().distanceTo(vector.get(entry.getKey()));
        for (Map.Entry<FeatureType, Feature<?>> entry : vector.features.entrySet())
            if (!contains(entry.getKey()))
                sum += Math.abs(vector.get(entry.getKey()).position());
        return sum;
    }
}
