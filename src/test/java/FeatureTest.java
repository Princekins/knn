import com.iancaffey.knn.Classification;
import com.iancaffey.knn.feature.Feature;
import com.iancaffey.knn.util.Features;
import com.iancaffey.knn.util.PrimitiveType;

/**
 * FeatureTest
 *
 * @author Ian
 * @version 1.0
 */
public class FeatureTest {
    public static void main(String[] args) {
        Feature<?>[] features = {Features.fromNumber(Features.asType("some_int_class"), 0.0), Features.fromNumber(Features.asType("some_int_class"), 2.0), Features.fromNumber(Features.asType("some_int_class"), 4.0), Features.fromNumber(Features.asType("some_int_class"), 6.0), Features.fromNumber(Features.asType("some_int_class"), 8.0), Features.fromNumber(Features.asType("some_int_class"), 10.0)};
        Classification classification = Features.asSpace(features).classify(Features.asSet(Features.fromNumber(Features.asType("some_int_class"), 4)), 4);
        System.out.println("Closest: " + classification.feature().value());
        for (Feature<?> neighbor : classification.neighbors())
            System.out.println("Neighbor: " + neighbor.value());

        //one-liner
        Features.asSpace(Features.fromFeatures(PrimitiveType.OBJECT, Object.class, Features.fromDouble(24.0)), Features.fromFeatures(PrimitiveType.OBJECT, Object.class, Features.fromDouble(48.0))).classify(Features.asSet(Features.fromDouble(30)), 4);
    }
}
