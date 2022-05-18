
public class Test {	
	
	
	public static void main(String[] args) {
		m(n(2));
	}
	
	
	public static void m(int i) {
		i *= 2;
		i *= 2;
	}
	
	public static int n(int i) {
		i *= 2;
		i *= 2;
		return i;
	}

}
