package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long a = in.nextInt();
        long s = in.nextInt();
        long k = in.nextInt();
        long x = in.nextInt();
        long y = in.nextInt();

        long l = 0, r = k, mid;
        while (l < r) {
            mid = (l + r + 1) >>> 1;
            if (a + x * mid <= s + y * (k - mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        if (a + x * l != s + y * (k - l)) out.print(-1);
        else out.print(l);
    }
}
