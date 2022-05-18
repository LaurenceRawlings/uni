import java.util.Scanner;

public class Sphnix {

	public static int unknown(int x, int y) {
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.print("x: ");
		int x = input.nextInt();

		System.out.print("y: ");
		int y = input.nextInt();

		System.out.println();

		System.out.println("unknown =  " + unknown(x, y));
		System.out.println();
	}
}
