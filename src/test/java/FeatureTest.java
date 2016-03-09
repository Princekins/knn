import com.knn.Classification;
import com.knn.FeatureSpace;
import com.knn.feature.Feature;
import com.knn.feature.FeatureVector;
import com.knn.feature.Features;
import com.knn.util.PrimitiveType;

/**
 * FeatureTest
 *
 * @author Ian
 * @version 1.0
 */
public class FeatureTest {
    public static void main(String[] args) {
        Feature<Double> feature = Features.fromDouble(24.0);
        Feature<Double> feature2 = Features.fromDouble(48.0);
        FeatureVector<Class<?>> vector = Features.fromFeatures(PrimitiveType.OBJECT, Object.class, feature);
        FeatureVector<Class<?>> vector2 = Features.fromFeatures(PrimitiveType.OBJECT, Object.class, feature2);
        FeatureSpace space = new FeatureSpace(vector, vector2);
        Classification classification = space.classify(Features.asSet(Features.fromDouble(30)), 4);
    }
}
