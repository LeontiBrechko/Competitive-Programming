package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskF {
    int n;
    int[] dp;
    boolean[][] adj;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        adj = new boolean[n][n];
        String nextLine;
        for (int i = 0; i < n; i++) {
            nextLine = in.next();
            for (int j = 0; j < n; j++) {
                adj[i][j] = nextLine.charAt(j) == 'Y';
            }
        }

        dp = new int[1 << n];
        Arrays.fill(dp, -1);
        int maxRes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j]) {
                    maxRes = Math.max(maxRes, findPair((1 << i) | (1 << j)) + 2);
                }
            }
        }
        out.print(maxRes);
    }

    private int findPair(int mask) {
        if (mask == ((1 << n) - 1)) return 0;
        if (dp[mask] != -1) return dp[mask];

        dp[mask] = 0;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][j] && ((1 << j) & mask) == 0) {
                        dp[mask] = Math.max(dp[mask], findPair((1 << i) | (1 << j) | mask) + 2);
                    }
                }
            }
        }

        return dp[mask];
    }
}
