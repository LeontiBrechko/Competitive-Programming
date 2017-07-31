package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int a, b;
        long ab, root;
        while (n-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            ab = (long) a * b;
            root = root(ab);

            if (root * root * root == ab && a % root == 0 && b % root == 0) out.println("Yes");
            else out.println("No");
        }
    }

    private long root(long x) {
        long l = 0, r = 1000005, mid;
        while (l < r) {
            mid = (l + r + 1) >>> 1;
            if (mid * mid * mid <= x) l = mid;
            else r = mid - 1;
        }

        return l;
    }
}
