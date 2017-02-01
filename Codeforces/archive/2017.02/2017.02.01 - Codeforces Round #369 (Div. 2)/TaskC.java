package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final long INF = Long.MAX_VALUE / 2L;
    int n;
    int m;
    int k;
    int[] c;
    int[][] p;
    long[][][] dp;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        c = in.nextIntArray(n);
        p = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = in.nextInt();
            }
        }

        dp = new long[2][k + 1][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        if (c[0] == 0) for (int i = 0; i < m; i++) dp[0][1][i] = p[0][i];
        else dp[0][1][c[0] - 1] = 0;

        int nextIndex = 0;
        for (int i = 1; i < n; i++) {
            nextIndex ^= 1;
            for (int j = 0; j < k + 1; j++) Arrays.fill(dp[nextIndex][j], INF);
            for (int j = 1; j < k + 1; j++) {
                if (c[i] == 0) {
                    for (int l = 0; l < m; l++) {
                        dp[nextIndex][j][l] =
                                Math.min(dp[nextIndex][j][l], dp[nextIndex ^ 1][j][l] + p[i][l]);
                        for (int o = 0; o < m; o++)
                            if (o != l)
                                dp[nextIndex][j][l] =
                                        Math.min(dp[nextIndex][j][l], dp[nextIndex ^ 1][j - 1][o] + p[i][l]);
                    }
                } else {
                    dp[nextIndex][j][c[i] - 1] =
                            Math.min(dp[nextIndex][j][c[i] - 1], dp[nextIndex ^ 1][j][c[i] - 1]);
                    for (int l = 0; l < m; l++) {
                        if (l != c[i] - 1) dp[nextIndex][j][c[i] - 1] =
                                Math.min(dp[nextIndex][j][c[i] - 1], dp[nextIndex ^ 1][j - 1][l]);
                    }
                }
            }
        }

        long res = INF;
        for (int i = 0; i < m; i++) res = Math.min(res, dp[nextIndex][k][i]);
        out.print(res == INF ? -1 : res);
    }
}
