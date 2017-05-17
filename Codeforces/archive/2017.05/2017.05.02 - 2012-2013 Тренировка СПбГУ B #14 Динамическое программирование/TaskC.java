package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    int n, finishMask, startPoint, minValue, next;
    int[][] adj, dp, path;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        adj = in.nextIntTable(n, n);
        finishMask = (1 << n) - 1;
        dp = new int[n][finishMask + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        path = new int[n][finishMask + 1];
        startPoint = -1;
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            next = tsp(i, 1 << i);
            if (next < minValue) {
                minValue = next;
                startPoint = i;
            }
        }
        out.println(minValue);
        out.printf("%d ", startPoint + 1);
        for (int i = startPoint, mask = 1 << startPoint; path[i][mask] != -1;) {
            out.printf("%d ", path[i][mask] + 1);
            i = path[i][mask];
            mask = mask | (1 << i);
        }
    }

    private int tsp(int pos, int mask) {
        if (mask == finishMask) {
            path[pos][mask] = -1;
            return 0;
        }
        if (dp[pos][mask] != Integer.MAX_VALUE) return dp[pos][mask];

        int nextDist, nextPoint = -1;
        for (int i = 0; i < n; i++) {
            if (i != pos && ((1 << i) & mask) == 0) {
                nextDist = tsp(i, mask | (1 << i)) + adj[pos][i];
                if (nextDist < dp[pos][mask]) {
                    dp[pos][mask] = nextDist;
                    nextPoint = i;
                }
            }
        }

        path[pos][mask] = nextPoint;
        return dp[pos][mask];
    }
}
