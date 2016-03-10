package com.knn;

import com.knn.feature.Feature;
import com.knn.feature.FeatureSet;
import com.knn.util.Features;

import java.util.Arrays;

/**
 * StaticClassifier
 *
 * @author Ian Caffey
 * @version 1.0
 */
public class StaticClassifier implements Classifier {
    @Override
    public Classification classify(FeatureSet set, int k, Feature<?>... features) {
        if (set == null || k < 0 || features == null || features.length == 0)
            throw new IllegalArgumentException();
        if (k == 0)
            return Classification.NONE;
        Arrays.sort(features, (o1, o2) -> Double.compare(Features.distance(set, o1), Features.distance(set, o2)));
        return new Classification(features[0], Arrays.copyOf(features, k));
    }
}
