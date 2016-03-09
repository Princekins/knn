import com.knn.Classification;
import com.knn.feature.Feature;
import com.knn.feature.Features;

/**
 * FeatureTest
 *
 * @author Ian
 * @version 1.0
 */
public class FeatureTest {
    public static void main(String[] args) {
        Feature<?>[] features = {Features.fromNumber(0.0), Features.fromNumber(2.0), Features.fromNumber(4.0), Features.fromNumber(6.0), Features.fromNumber(8.0), Features.fromNumber(10.0)};
        Classification classification = Features.asSpace(features).classify(Features.asSet(Features.fromNumber(4)), 4);
        System.out.println("Closest: " + classification.feature().value());
        for (Feature<?> neighbor : classification.neighbors())
            System.out.println("Neighbor: " + neighbor.value());
    }
}
