package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] p = in.nextIntArray(n);

        StringBuilder res = new StringBuilder();

        int l, r, x, next;
        for (int i = 0; i < m; i++) {
            l = in.nextInt() - 1;
            r = in.nextInt() - 1;
            x = in.nextInt() - 1;
            next = 0;

            for (int j = l; j <= r; j++) {
                if (p[j] < p[x]) next++;
            }

            res.append((l + next) == x ? "Yes\n" : "No\n");
        }
        out.print(res);
    }
}
