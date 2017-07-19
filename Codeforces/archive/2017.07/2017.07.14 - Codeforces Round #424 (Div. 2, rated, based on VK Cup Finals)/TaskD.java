package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskD {
    int n, k, p;
    int[] a, b;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        p = in.nextInt();
        a = in.nextIntArray(n);
        b = in.nextIntArray(k);
        Arrays.sort(a);
        Arrays.sort(b);

        long l = 0, r = (int) (2 * 10e9 + 10);
        long mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }

        out.print(l);
    }

    private boolean check(long maxTime) {
        for (int i = 0, j = 0; i < n; i++, j++) {
            while (j < k && Math.abs((long) a[i] - b[j]) + Math.abs((long) b[j] - p) > maxTime) j++;
            if (j >= k) return false;
        }
        return true;
    }
}
