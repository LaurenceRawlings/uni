public class Main {

    public static void main(String[] args) {
        int z = multiply(3,3);
        System.out.println(z);

        int y = fib(3);
        System.out.println(y);
    }

    public static int multiply(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        } else if (n == 1){
            return m;
        }

        return multiply(n, m-1) + n;
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } if (n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
}
