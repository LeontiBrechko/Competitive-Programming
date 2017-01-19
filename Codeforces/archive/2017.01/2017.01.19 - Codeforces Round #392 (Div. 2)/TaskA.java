package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] > max) max = a[i];
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != max) res += (max - a[i]);
        }

        out.print(res);
    }
}
