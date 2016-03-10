package com.iancaffey.knn;

import com.iancaffey.knn.feature.Feature;
import com.iancaffey.knn.feature.FeatureSet;

import java.util.Arrays;

/**
 * FeatureSpace
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FeatureSpace {
    private static final Classifier DEFAULT = new StaticClassifier();
    private final Feature<?>[] features;
    private Classifier classifier;

    public FeatureSpace(Feature<?>... features) {
        this(DEFAULT, features);
    }

    public FeatureSpace(Classifier classifier, Feature<?>... features) {
        if (features == null || features.length == 0)
            throw new IllegalArgumentException();
        this.classifier = classifier;
        this.features = Arrays.copyOf(features, features.length);
    }

    public Classifier classifier() {
        return classifier;
    }

    public void classifier(Classifier classifier) {
        this.classifier = classifier;
    }

    public Feature<?>[] features() {
        return Arrays.copyOf(features, features.length);
    }

    public Classification classify(FeatureSet set, int k) {
        Classifier classifier = classifier();
        if (classifier == null)
            return null;
        return classifier.classify(set, k, features());
    }
}
