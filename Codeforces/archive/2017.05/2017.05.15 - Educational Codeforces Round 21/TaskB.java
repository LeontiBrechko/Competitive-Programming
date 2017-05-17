package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        int count = 1;
        double res, next = 0.0D;
        for (int i = 0; i < k; i++) {
            next += a[i];
        }
        res = next;

        for (int i = k; i < n; i++) {
            next = next + a[i] - a[i - k];
            res += next;
            count++;
        }

        out.print(res / count);
    }
}
