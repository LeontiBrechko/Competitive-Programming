package test.on2017_03.on2017_03_02_Codeforces_Round__247__Div__2_.C___k_Tree;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int MOD = 1000000007;

    int n, k, d;
    int[][] dp;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        d = in.nextInt();
        dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        out.print(stepInto(0, false));
    }

    private int stepInto(int sum, boolean doesHaveD) {
        if (sum == n) {
            if (doesHaveD) return 1;
            else return 0;
        }
        if (sum > n) return 0;
        if (dp[sum][doesHaveD ? 1 : 0] != -1) return dp[sum][doesHaveD ? 1 : 0];

        int res = 0;
        for (int i = 1; i <= k; i++) {
            res += stepInto(sum + i, doesHaveD || i >= d);
            if (res >= MOD) res -= MOD;
        }
        return dp[sum][doesHaveD ? 1 : 0] = res;
    }
}
