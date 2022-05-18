public class SingleTest {
	
	private int a,b,c;
	private TriangleClassifier.TriangleType classification;
	
	public SingleTest(int x, int y, int z, TriangleClassifier.TriangleType expectedResult) {
	   a = x;
	   b = y;
	   c = z;
	   classification = expectedResult;
	}
	
	public int FirstInput () {
		return a;
	}
	
	public int SecondInput () {
		return b;
	}
	
	public int ThirdInput () {
		return c;
	}
	
	public TriangleClassifier.TriangleType Output () {
		return classification;
	}		

}

