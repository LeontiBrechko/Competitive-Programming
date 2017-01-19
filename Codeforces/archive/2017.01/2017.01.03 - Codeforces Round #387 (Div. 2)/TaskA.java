package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int minDiff = Integer.MAX_VALUE;
        int a, b, resA = 1, resB = n;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                a = i;
                b = n / i;
                if (a <= b) {
                    if (minDiff > b - a) {
                        minDiff = b - a;
                        resA = a;
                        resB = b;
                    }
                } else break;
            }
        }
        out.printf("%d %d", resA, resB);
    }
}
