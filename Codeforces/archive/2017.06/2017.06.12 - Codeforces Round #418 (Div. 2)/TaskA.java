package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        boolean isPossible = false;
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (i > 0 && (a[i - 1] > a[i] && a[i] != 0)) {
                isPossible = true;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int next;
        for (int i = 0; i < k; i++) {
            next = in.nextInt();
            min = Math.min(next, min);
            max = Math.max(next, max);
        }

        for (int i = 0; i < n && !isPossible; i++) {
            if (a[i] == 0) {
                if ((i > 0 && (a[i - 1] > min || a[i - 1] == 0)) ||
                        (i < n - 1 && (a[i + 1] < max || a[i + 1] == 0)))
                    isPossible = true;
            }
        }

        out.print(isPossible ? "Yes" : "No");
    }
}
