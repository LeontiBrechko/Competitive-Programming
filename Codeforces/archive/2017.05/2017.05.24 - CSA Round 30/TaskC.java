package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = in.nextIntArray(n);

        int[] addValue = new int[n];
        int i, s;
        double res = 0;
        while (q > 0) {
            q--;
            if (in.nextInt() == 0) {
                i = in.nextInt() - 1;
                s = in.nextInt();
                res += s;
                a[i] += s;
                addValue[i] += s;
            } else {
                i = in.nextInt() - 1;
                out.println(a[i] - ((res - addValue[i]) / (n - 1)));
            }
        }
    }
}
