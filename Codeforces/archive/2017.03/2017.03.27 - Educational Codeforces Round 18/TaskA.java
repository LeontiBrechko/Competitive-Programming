package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] < min) {
                min = a[i] - a[i - 1];
                res = 1;
            } else if (a[i] - a[i - 1] == min) {
                res++;
            }
        }

        out.printf("%d %d", min, res);
    }
}
