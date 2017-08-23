package tasks;


import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] twos = new int[n];
        int[] fives = new int[n];

        long next;
        int t, f;
        for (int i = 0; i < n; i++) {
            next = in.nextLong();

            t = 0;
            while (next % 2L == 0L) {
                next /= 2L;
                t++;
            }
            twos[i] = t;

            f = 0;
            while (next % 5L == 0L) {
                next /= 5L;
                f++;
            }
            fives[i] = f;
        }

        int[][][] dp = new int[2][k + 1][10000];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[0][i], -1);
            Arrays.fill(dp[1][i], -1);
        }
        dp[0][0][0] = 0;

        int flag = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < 10000; l++) {
                    if (dp[flag ^ 1][j][l] == -1) continue;

                    if (j + 1 <= k)
                        dp[flag][j + 1][l + fives[i]] = Math.max(dp[flag][j + 1][l + fives[i]],
                                dp[flag ^ 1][j][l] + twos[i]);
                    dp[flag][j][l] = Math.max(dp[flag][j][l], dp[flag ^ 1][j][l]);
                }
            }

            flag ^= 1;
            if (i != n - 1) for (int j = 0; j <= k; j++) Arrays.fill(dp[flag][j], -1);
        }

        flag ^= 1;
        int res = 0;
        for (int j = 0; j < 10000; j++) res = Math.max(res, Math.min(j, dp[flag][k][j]));

        out.print(res);
    }
}
