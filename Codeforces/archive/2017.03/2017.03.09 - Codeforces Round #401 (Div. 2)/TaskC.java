package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int[][] numberOfRows = new int[n][m];
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] >= grid[i - 1][j])
                    numberOfRows[i][j] = numberOfRows[i - 1][j] + 1;
                dp[i] = Math.max(numberOfRows[i][j], dp[i]);
            }
        }

        int k = in.nextInt();
        int l, r;
        StringBuilder res = new StringBuilder();
        while (k-- > 0) {
            l = in.nextInt();
            r = in.nextInt();
            if (dp[r - 1] >= r - l) res.append("Yes\n");
            else res.append("No\n");
        }
        out.print(res);
    }
}
