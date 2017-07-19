package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        Arrays.sort(a);
        long currentSolvable = k * 2;
        int res = 0;
        for (int i = 0; i < n;) {
            if (a[i] <= currentSolvable) {
                currentSolvable = Math.max(currentSolvable, a[i] * 2);
                i++;
                continue;
            }

            while (a[i] > currentSolvable) {
                currentSolvable *= 2L;
                res++;
            }
        }

        out.print(res);
    }
}
