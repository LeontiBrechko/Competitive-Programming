package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int time[] = new int[n];
        int t, k, d, currentRes, availableCount;
        for (int i = 0; i < q; i++) {
            t = in.nextInt();
            k = in.nextInt();
            d = in.nextInt();
            currentRes = 0;
            availableCount = 0;
            for (int j = 0; j < n; j++) {
                if (availableCount == k) break;
                if (time[j] < t) availableCount++;
            }
            if (availableCount == k) {
                for (int j = 0; j < n; j++) {
                    if (k == 0) break;
                    if (time[j] < t) {
                        time[j] = t + d - 1;
                        currentRes += (j + 1);
                        k--;
                    }
                }
            } else {
                currentRes = -1;
            }
            out.println(currentRes);
        }
    }
}
