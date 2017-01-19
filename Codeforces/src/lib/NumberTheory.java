package lib;

public class NumberTheory {
    public static int gcd(int a, int b) {
        int temp;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }
}
