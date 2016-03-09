import com.knn.Classification;
import com.knn.feature.Feature;
import com.knn.util.Features;

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
    }
}
