package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int [] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        for (int i = 1; i <= n; i++) a[i] ^= a[i - 1];

        int res = n;
        while (!has(res, a, n)) res--;

        out.print(res);
    }

    private boolean has(int length, int[] a, int n) {
        for (int i = 1; i <= n - length + 1; i++) {
            if ((a[i + length - 1] ^ a[i - 1]) > 0) {
                return true;
            }
        }
        return false;
    }
}
