package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int l = in.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (d < 0) {
                res[i] = 1;
                d = 1 - d;
            } else if (d == 0) {
                res[i] = 1;
                d = 1;
            } else if (d >= 1 && d + 1 <= l) {
                res[i] = d + 1;
                d = 1;
            } else {
                res[i] = l;
                d = l - d;
            }
        }

        if (d < 1 || d > l) out.print(-1);
        else {
            res[n - 1] = d;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) result.append(res[i]).append(' ');
            out.print(result);
        }
    }
}
