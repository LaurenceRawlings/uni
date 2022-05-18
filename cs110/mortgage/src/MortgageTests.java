import static org.junit.Assert.*;
import org.junit.Test;

public class MortgageTests {

        @Test
        public void test1() {
        	int x = Mortgage.calculateMortgage(25, 50000, Mortgage.Gender.MALE);
            assertEquals(375000, x);
        }
        
        @Test
        public void test2() {
        	int x = Mortgage.calculateMortgage(40, 50000, Mortgage.Gender.MALE);
            assertEquals(275000, x);
        }

        @Test
        public void test3() {
        	int x = Mortgage.calculateMortgage(50, 50000, Mortgage.Gender.MALE);
            assertEquals(175000, x);
        }

        @Test
        public void test4() {
        	int x = Mortgage.calculateMortgage(25, 50000, Mortgage.Gender.FEMALE);
            assertEquals(350000, x);
        }
        
        @Test
        public void test5() {
        	int x = Mortgage.calculateMortgage(40, 50000, Mortgage.Gender.FEMALE);
            assertEquals(250000, x);
        }
        
        @Test
        public void test6() {
        	int x = Mortgage.calculateMortgage(50, 50000, Mortgage.Gender.FEMALE);
            assertEquals(150000, x);
        }
        
        @Test
        public void test7() {
        	int x = Mortgage.calculateMortgage(90, 50000, Mortgage.Gender.MALE);
            assertEquals(0, x);
        }
        
        @Test
        public void test8() {
        	int x = Mortgage.calculateMortgage(90, 50000, Mortgage.Gender.FEMALE);
            assertEquals(0, x);
        }      
        
        @Test
        public void test9() {
        	int x = Mortgage.calculateMortgage(15, 50000, Mortgage.Gender.MALE);
            assertEquals(0, x);
        }
        
        @Test
        public void tes10() {
        	int x = Mortgage.calculateMortgage(15, 50000, Mortgage.Gender.FEMALE);
            assertEquals(0, x);
        }          
     
}
