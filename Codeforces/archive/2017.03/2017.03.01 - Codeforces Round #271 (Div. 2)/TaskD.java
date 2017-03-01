package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    private static final int MAX = 100001;
    private static final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int k = in.nextInt();
        int[] dp = new int[MAX];
        for (int i = 0; i < k; i++) dp[i] = 1;
        for (int i = k; i < MAX; i++) dp[i] = (dp[i - k] + dp[i - 1]) % MOD;
        for (int i = 1; i < MAX; i++) dp[i] = (dp[i] + dp[i - 1]) % MOD;
        int res;
        for (int i = 0; i < t; i++) {
            res = -(dp[in.nextInt() - 1] - dp[in.nextInt()]);
            if (res < 0) out.println(res + MOD);
            else out.println(res);
        }
    }
}
