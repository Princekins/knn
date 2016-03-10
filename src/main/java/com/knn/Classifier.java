package com.knn;

import com.knn.feature.Feature;
import com.knn.feature.FeatureSet;

/**
 * Classifier
 *
 * @author Ian Caffey
 * @version 1.0
 */
public interface Classifier {
    public Classification classify(FeatureSet set, int k, Feature<?>... features);
}
