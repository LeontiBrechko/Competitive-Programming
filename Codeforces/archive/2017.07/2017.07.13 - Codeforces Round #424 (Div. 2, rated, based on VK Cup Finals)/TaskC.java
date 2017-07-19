package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        int n = in.nextInt();
        int[] a = in.nextIntArray(k);
        int[] b = in.nextIntArray(n);
        HashSet<Integer> sums = new HashSet<>();
        int[] possibilities = new int[20000010];
        int offset = 10000000;
        int res = 0;

        int s = a[0];
        sums.add(s);
        for (int i = 1; i < k; i++) {
            s += a[i];
            sums.add(s);
        }

        int next;
        for (int i = 0; i < n; i++) {
            for (Integer sum : sums) {
                next = b[i] - sum;
                possibilities[next + offset]++;
            }
        }

        for (int possibility : possibilities) {
            if (possibility == n) res++;
        }

        out.print(res);
    }
}
