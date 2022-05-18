import static org.junit.Assert.*;
import org.junit.Test;

public class TestingWithArrays {

	public SingleTest[] myTestSuite() {
		SingleTest[] tmp = new SingleTest[] { 
				new SingleTest(6, 14, 2000, "15.6.---2000"),
				new SingleTest(6, 14, 1996, "15.6.---1996"), 
				new SingleTest(6, 14, 2002, "15.6.---2002"),
				new SingleTest(6, 29, 2000, "30.6.---2000"), 
				new SingleTest(6, 29, 1996, "30.6.---1996"),
				new SingleTest(6, 29, 2002, "30.6.---2002"), 
				new SingleTest(6, 30, 2000, "1.7.---2000"),
				new SingleTest(6, 30, 1996, "1.7.---1996"), 
				new SingleTest(6, 30, 2002, "1.7.---2002"),
				new SingleTest(6, 31, 2000, "Invalid input date"), 
				new SingleTest(6, 31, 1996, "Invalid input date"),
				new SingleTest(6, 31, 2002, "Invalid input date"), 
				new SingleTest(7, 14, 2000, "15.7.---2000"),
				new SingleTest(7, 14, 1996, "15.7.---1996"), 
				new SingleTest(7, 14, 2002, "15.7.---2002"),
				new SingleTest(7, 29, 2000, "30.7.---2000"), 
				new SingleTest(7, 29, 1996, "30.7.---1996"),
				new SingleTest(7, 29, 2002, "30.7.---2002"), 
				new SingleTest(7, 30, 2000, "31.7.---2000"),
				new SingleTest(7, 30, 1996, "31.7.---1996"), 
				new SingleTest(7, 30, 2002, "31.7.---2002"),
				new SingleTest(7, 31, 2000, "1.8.---2000"), 
				new SingleTest(7, 31, 1996, "1.8.---1996"),
				new SingleTest(7, 31, 2002, "1.8.---2002"), 
				new SingleTest(2, 14, 2000, "15.2.---2000"),
				new SingleTest(2, 14, 1996, "15.2.---1996"), 
				new SingleTest(2, 14, 2002, "15.2.---2002"),
				new SingleTest(2, 29, 2000, "1.3.---2000"), 
				new SingleTest(2, 29, 1996, "1.3.---1996"),
				new SingleTest(2, 29, 2002, "Invalid input date"), 
				new SingleTest(2, 30, 2000, "Invalid input date"),
				new SingleTest(2, 30, 1996, "Invalid input date"), 
				new SingleTest(2, 30, 2002, "Invalid input date"),
				new SingleTest(2, 31, 2000, "Invalid input date"), 
				new SingleTest(2, 31, 1996, "Invalid input date"),
				new SingleTest(2, 31, 2002, "Invalid input date") };

		return tmp;
	}

	@Test
	public void ExecuteTestSuite() {
		SingleTest[] TestSuite;
		TestSuite = myTestSuite();
		for (int i = 0; i < TestSuite.length; i++) {
			assertEquals(TestSuite[i].Output(),
					nextDateFunction.tomorrow(TestSuite[i].month(), TestSuite[i].day(), TestSuite[i].year()));
		}
	}

}
