package com.iancaffey.knn.lang;

import com.iancaffey.knn.util.FeatureType;

/**
 * DimensionException
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DimensionException extends RuntimeException {
    public DimensionException(FeatureType one, FeatureType two) {
        super(String.format("%s and %s cannot be compared for distance as their planes are not orthogonal.", one, two));
    }
}
