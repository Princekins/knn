package com.iancaffey.knn;

import com.iancaffey.knn.feature.Feature;
import com.iancaffey.knn.feature.FeatureSet;

/**
 * Classifier
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Classifier {
    public Classification classify(FeatureSet set, int k, Feature<?>... features);
}
