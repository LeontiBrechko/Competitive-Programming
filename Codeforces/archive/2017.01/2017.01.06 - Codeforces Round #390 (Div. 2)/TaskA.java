package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        boolean isPossible = false;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] = in.nextInt();
            if (a[i] != 0) isPossible = true;
        }

        if (isPossible) {
            out.println("YES");
            int r = n - 1;
            while (sum == 0) {
                sum -= a[r];
                r--;
            }
            if (r == n - 1) out.printf("%d\n%d %d\n", 1, 1, n);
            else out.printf("%d\n%d %d\n%d %d\n", 2, 1, r + 1, r + 2, n);
        } else out.print("NO");
    }
}
