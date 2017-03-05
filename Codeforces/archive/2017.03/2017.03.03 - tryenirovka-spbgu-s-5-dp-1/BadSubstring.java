package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class BadSubstring {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        if (n == 0) {
            out.print(1);
            return;
        }

        long[][] dp = new long[n][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] += (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]);
            dp[i][1] += (dp[i - 1][1] + dp[i - 1][2]);
            dp[i][2] += (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]);
        }

        out.print(dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]);
    }
}
