package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    long n, k, value, reserved, current, needed, diff, min, max;
    int level;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextLong();
        k = in.nextLong();
        level = log2(k);
        value = n;
        for (int i = 0; i < level; i++) value >>>= 1;
        current = n - value * (long) Math.pow(2, level);
        reserved = (long) Math.pow(2, level) - 1;
        needed = reserved - current;
        diff = ((long) Math.pow(2, level + 1) - 1) - needed;
        if (k > diff) {
            value--;
        }
        if (value % 2 == 0) {
            max = value / 2;
            min = max - 1;
        } else {
            min = max = value / 2;
        }
        out.printf("Case #%d: %d %d\n", testNumber, max, min);
    }

    private int log2(long n) {
        int res = 0;
        while ((n >>> 1) > 0) {
            res++;
            n >>>= 1;
        }
        return res;
    }
}
