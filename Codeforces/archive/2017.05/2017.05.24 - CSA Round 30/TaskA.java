package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] % 10 != a[i + 1] / 10) res++;
        }
        out.print(res);
    }
}
