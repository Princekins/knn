package com.knn.feature;

import com.knn.FeatureSpace;
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

    public static NumericFeature<Short> fromNumber(short s) {
        return new NumericFeature<>(PrimitiveType.NUMBER, s);
    }

    public static NumericFeature<Integer> fromNumber(int i) {
        return new NumericFeature<>(PrimitiveType.NUMBER, i);
    }

    public static NumericFeature<Float> fromNumber(float f) {
        return new NumericFeature<>(PrimitiveType.NUMBER, f);
    }

    public static NumericFeature<Double> fromNumber(double d) {
        return new NumericFeature<>(PrimitiveType.NUMBER, d);
    }


    public static <T> FeatureVector<T> fromFeatures(FeatureType type, T t, Feature<?>... features) {
        if (features == null)
            throw new IllegalArgumentException();
        return new FeatureVector<>(type, t, asSet(features));
    }

    public static FeatureSpace asSpace(Feature<?>... features) {
        return new FeatureSpace(features);
    }

    public static FeatureSet asSet(Feature<?>... features) {
        if (features == null)
            throw new IllegalArgumentException();
        FeatureSet set = new FeatureSet();
        for (Feature<?> feature : features)
            set.set(feature.type(), feature);
        return set;
    }

    public static <T> double distance(FeatureSet set, Feature<T> feature) {
        if (set == null || feature == null)
            return Double.MAX_VALUE;
        if (!(feature instanceof FeatureVector))
            return set.contains(feature.type()) ? set.<T>get(feature.type()).distanceTo(feature) : Double.MAX_VALUE;
        FeatureVector<?> vector = (FeatureVector<?>) feature;
        double sum = 0.0;
        for (FeatureType type : set.types())
            if (vector.features().contains(type))
                sum += Math.pow(set.get(type).distanceTo(vector.features().get(type)), 2);
        for (FeatureType type : vector.features().types())
            if (!set.contains(type))
                sum += Math.pow(vector.features().get(type).position(), 2);
        return Math.sqrt(sum);
    }
}
