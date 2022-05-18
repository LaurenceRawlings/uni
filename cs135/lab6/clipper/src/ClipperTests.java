import static org.junit.Assert.*;
import org.junit.Test;

public class ClipperTests {

        @Test
        public void clip1() {
                int x = Clipper.clip(1, 9, 0);
                assertEquals(1, x);
        }

        /*
        @Test
        public void clip2() {
                int x = Clipper.clip(1, 9, 10);
                assertEquals(9, x);
        }

        @Test
        public void clip3() {
                int x = Clipper.clip(1, 9, 5);
                assertEquals(5, x);
        }

        @Test
        public void clip4() {
                int x = Clipper.clip(9, 1, 5);
                assertEquals(1, x);
        }
        */
}
