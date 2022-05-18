public class SingleTest {

	private int m, d, y;
	private String output;

	public SingleTest(int x, int y, int z, String o) {
		d = x;
		m = y;
		this.y = z;
		output = o;
	}

	public int month() {
		return m;
	}

	public int day() {
		return d;
	}

	public int year() {
		return y;
	}

	public String Output() {
		return output;
	}

}
