package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int res;
        if (n % 2 == 0) {
            int mid = n / 2;
            if (m > mid) {
                res = Math.max(m - 1, 1);
            } else {
                res = Math.min(m + 1, n);
            }
        } else {
            int mid = (n + 1) / 2;
            if (m > mid) {
                res = Math.max(m - 1, 1);
            } else if (m < mid) {
                res = Math.min(m + 1, n);
            } else {
                res = Math.max(mid - 1, 1);
            }
        }
        out.print(res);
    }
}
