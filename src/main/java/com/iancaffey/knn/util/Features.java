package com.iancaffey.knn.util;

import com.iancaffey.knn.FeatureSpace;
import com.iancaffey.knn.feature.Feature;
import com.iancaffey.knn.feature.FeatureSet;
import com.iancaffey.knn.feature.FeatureVector;
import com.iancaffey.knn.feature.NumericFeature;

/**
 * Features
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Features {
    private Features() {

    }

    public static int compare(FeatureSet set, Feature<?> one, Feature<?> two) {
        if (set == null)
            throw new IllegalArgumentException();
        int value = Double.compare(Features.distance(set, one), Features.distance(set, two));
        return value != 0 ? value : Integer.compare(intersection(set, one), intersection(set, two));
    }

    public static int intersection(FeatureSet set, Feature<?> feature) {
        if (set == null)
            throw new IllegalArgumentException();
        if (feature == null)
            return 0;
        if (!(feature instanceof FeatureVector<?>))
            return set.contains(feature.type()) ? 1 : 0;
        int sum = 0;
        for (FeatureType type : ((FeatureVector) feature).features().types())
            if (set.contains(type))
                sum++;
        return sum;
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
        return fromNumber(PrimitiveType.NUMBER, s);
    }

    public static NumericFeature<Integer> fromNumber(int i) {
        return fromNumber(PrimitiveType.NUMBER, i);
    }

    public static NumericFeature<Float> fromNumber(float f) {
        return fromNumber(PrimitiveType.NUMBER, f);
    }

    public static NumericFeature<Double> fromNumber(double d) {
        return fromNumber(PrimitiveType.NUMBER, d);
    }

    public static NumericFeature<Short> fromNumber(FeatureType type, short s) {
        return new NumericFeature<>(type, s);
    }

    public static NumericFeature<Integer> fromNumber(FeatureType type, int i) {
        return new NumericFeature<>(type, i);
    }

    public static NumericFeature<Float> fromNumber(FeatureType type, float f) {
        return new NumericFeature<>(type, f);
    }

    public static NumericFeature<Double> fromNumber(FeatureType type, double d) {
        return new NumericFeature<>(type, d);
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

    public static StringType asType(String name) {
        return new StringType(name);
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
