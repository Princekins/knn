package com.knn.feature;

import com.knn.util.FeatureType;

import java.util.HashMap;
import java.util.Map;

/**
 * FeatureSet
 *
 * @author Ian Caffey
 * @version 1.0
 */
public class FeatureSet {
    private final Map<FeatureType, Feature<?>> features = new HashMap<>();

    public void set(FeatureType type, Feature<?> feature) {
        if (type == null || feature == null)
            throw new IllegalArgumentException();
        features.put(type, feature);
    }

    public <T> Feature<T> get(FeatureType type) {
        return (Feature<T>) features.get(type);
    }

    public boolean contains(FeatureType type) {
        return features.containsKey(type);
    }

    public FeatureType[] types() {
        return features.keySet().toArray(new FeatureType[features.size()]);
    }

    public Feature<?>[] features() {
        return features.values().toArray(new Feature[features.size()]);
    }
}
