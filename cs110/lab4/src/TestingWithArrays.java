import static org.junit.Assert.*;

import org.junit.Test;

public class TestingWithArrays {

	public SingleTest[]  myTestSuite () {
	       SingleTest[] tmp = new SingleTest [4];
	       tmp[0] = new SingleTest(5, 5, 5,TriangleClassifier.TriangleType.EQUILITERAL);
           tmp[1] = new SingleTest(2, 2, 3,TriangleClassifier.TriangleType.ISOSCELES);
	       tmp[2] = new SingleTest(3, 4, 5,TriangleClassifier.TriangleType.SCALENE);
           tmp[3] = new SingleTest(4, 1, 53,TriangleClassifier.TriangleType.NOT_A_TRIANGLE);           
           
           return tmp;    	
	}
	                                     	
       @Test  
       public void ExecuteTestSuite () {
       SingleTest[] TestSuite;
       TestSuite = myTestSuite();
       for (int i = 0; i < TestSuite.length; i++) {
    	    assertEquals(  TestSuite[i].Output(),
    		 	         TriangleClassifier.classify( TestSuite[i].FirstInput(),
	    		                                      TestSuite[i].SecondInput(),
	                                                  TestSuite[i].ThirdInput()
	                                          )  
    	              );	
    	}	
    }
    
}

