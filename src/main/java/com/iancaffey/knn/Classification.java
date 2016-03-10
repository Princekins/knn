package com.iancaffey.knn;

import com.iancaffey.knn.feature.Feature;

import java.util.Arrays;

/**
 * Classification
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Classification {
    public static Classification NONE = new Classification(null);
    private final Feature<?> feature;
    private final Feature<?>[] neighbors;

    public Classification(Feature<?> feature, Feature<?>... neighbors) {
        if (neighbors == null)
            throw new IllegalArgumentException();
        this.feature = feature;
        this.neighbors = Arrays.copyOf(neighbors, neighbors.length);
    }

    public Feature<?> feature() {
        return feature;
    }

    public Feature<?>[] neighbors() {
        return Arrays.copyOf(neighbors, neighbors.length);
    }
}
