import static org.junit.Assert.*;
import org.junit.Test;


public class TriangleClassifierTest {

    @Test
    public void test1Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 100, 1));
    }

    @Test
    public void test2Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 100, 2));
    }
    
    @Test
    public void test3Classify() {
        assertEquals(TriangleClassifier.TriangleType.EQUILITERAL, TriangleClassifier.classify(100, 100, 100));
    }
    
    @Test
    public void test4Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 100, 199));
    }
    
    @Test
    public void test5Classify() {
        assertEquals(TriangleClassifier.TriangleType.NOT_A_TRIANGLE, TriangleClassifier.classify(100, 100, 200));
    }
    
    @Test
    public void test6Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 1, 100));
    }
    
    @Test
    public void test7Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 2, 100));
    }
    
    @Test
    public void test8Classify() {
        assertEquals(TriangleClassifier.TriangleType.EQUILITERAL, TriangleClassifier.classify(100, 100, 100));
    }
    
    @Test
    public void test9Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(100, 199, 100));
    }
    
    @Test
    public void test10Classify() {
        assertEquals(TriangleClassifier.TriangleType.NOT_A_TRIANGLE, TriangleClassifier.classify(100, 200, 100));
    }
    
    
    @Test
    public void test11Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(1, 100, 100));
    }
    
    @Test
    public void test12Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(2, 100, 100));
    }
    
    @Test
    public void test13Classify() {
        assertEquals(TriangleClassifier.TriangleType.EQUILITERAL, TriangleClassifier.classify(100, 100, 100));
    }
    
    @Test
    public void test14Classify() {
        assertEquals(TriangleClassifier.TriangleType.ISOSCELES, TriangleClassifier.classify(199, 100, 100));
    }
    
    @Test
    public void test15Classify() {
        assertEquals(TriangleClassifier.TriangleType.NOT_A_TRIANGLE, TriangleClassifier.classify(200, 100, 100));
    }
    

}
