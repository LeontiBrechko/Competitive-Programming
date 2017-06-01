package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int s = in.nextInt();
        int[] a = in.nextIntArray(n);

        int l = 0, r = n, mid;
        long res = 0, current;
        while (l < r) {
            mid = (l + r + 1) >>> 1;
            current = nextResult(mid, a, s);
            if (current >= 0) {
                l = mid;
                res = current;
            } else {
                r = mid - 1;
            }
        }
        out.printf("%d %d", l, res);
    }

    private long nextResult(int k, int[] a, int s) {
        Long[] a1 = new Long[a.length];
        for (int i = 0; i < a.length; i++) {
            a1[i] = (long) a[i] + (i + 1L) * (long) k;
        }
        Arrays.sort(a1);
        long res = 0;
        for (int i = 0; i < k && s >= 0; i++) {
            res += a1[i];
            s -= a1[i];
        }
        if (s < 0) return Long.MIN_VALUE;
        else return res;
    }
}
