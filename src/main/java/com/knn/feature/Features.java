package com.knn.feature;

import com.knn.util.FeatureType;
import com.knn.util.PrimitiveType;

/**
 * Features
 *
 * @author Ian
 * @version 1.0
 */
public class Features {
    private Features() {

    }

    public static NumericFeature<Short> fromShort(short s) {
        return new NumericFeature<>(PrimitiveType.SHORT, s);
    }

    public static NumericFeature<Integer> fromInteger(int i) {
        return new NumericFeature<>(PrimitiveType.INTEGER, i);
    }

    public static NumericFeature<Float> fromFloat(float f) {
        return new NumericFeature<>(PrimitiveType.FLOAT, f);
    }

    public static NumericFeature<Double> fromDouble(double d) {
        return new NumericFeature<>(PrimitiveType.DOUBLE, d);
    }

    public static <T> FeatureVector<T> fromFeatures(FeatureType type, T t, Feature<?>... features) {
        if (features == null)
            throw new IllegalArgumentException();
        FeatureVector<T> vector = new FeatureVector<>(type, t);
        for (Feature<?> feature : features)
            vector.set(feature.type(), feature);
        return vector;
    }
}
