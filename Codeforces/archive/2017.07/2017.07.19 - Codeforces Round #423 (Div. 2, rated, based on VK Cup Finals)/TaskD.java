package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int d = 2;
        for (int i = 1; i + k < n; i++) {
            a[i + k] = i;
            if ((i - 1) % k <= 1) d++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i > 0; i--) res.append(i + 1).append(' ').append(a[i] + 1).append('\n');
        out.println(d);
        out.print(res);
    }
}
