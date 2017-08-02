package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[1002];
        int res = 0;
        int next;
        for (int i = 0; i < n; i++) {
            next = in.nextInt();
            a[next]++;
            res += next;
        }

        int maxS, index;
        maxS = 0;
        for (int i = 0; i < 1002; i++) {
            if (i * a[i] > maxS) {
                maxS = i * a[i];
            }
        }

        out.print(res - maxS);
    }
}
