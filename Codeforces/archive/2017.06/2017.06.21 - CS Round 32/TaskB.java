package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        Arrays.sort(a);
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(res, (long) a[i] * (n - i));
        }
        out.print(res);
    }
}
