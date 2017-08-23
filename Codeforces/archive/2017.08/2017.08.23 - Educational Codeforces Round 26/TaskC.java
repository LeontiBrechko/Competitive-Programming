package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        long res = 0;

        boolean isPossible;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                isPossible = x[i] + x[j] <= a && Math.max(y[i], y[j]) <= b;
                isPossible |= y[i] + y[j] <= b && Math.max(x[i], x[j]) <= a;
                isPossible |= y[i] + x[j] <= a && Math.max(x[i], y[j]) <= b;
                isPossible |= x[i] + y[j] <= b && Math.max(y[i], x[j]) <= a;
                isPossible |= x[i] + y[j] <= a && Math.max(y[i], x[j]) <= b;
                isPossible |= y[i] + x[j] <= b && Math.max(x[i], y[j]) <= a;
                isPossible |= y[i] + y[j] <= a && Math.max(x[i], x[j]) <= b;
                isPossible |= x[i] + x[j] <= b && Math.max(y[i], y[j]) <= a;

                if (isPossible) res = Math.max(res, (long) (x[i] * y[i]) + (x[j] * y[j]));
            }
        }

        out.print(res);
    }
}
