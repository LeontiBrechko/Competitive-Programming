public class RoadOrFlightHard {
    int n, k;
    int[] roadTime, flightTime;
    long[][][] dp;

    public long minTime(int N, int roadFirst, int roadProd, int roadAdd, int roadMod,
                        int flightFirst, int flightProd, int flightAdd, int flightMod, int K) {
        n = N;
        k = K;
        roadTime = new int[n];
        roadTime[0] = roadFirst % roadMod;
        flightTime = new int[n];
        flightTime[0] = flightFirst % flightMod;
        for (int i = 1; i < n; i++) {
            roadTime[i] = (int) (((long) roadTime[i - 1] * roadProd + roadAdd) % roadMod);
            flightTime[i] = (int) (((long) flightTime[i - 1] * flightProd + flightAdd) % flightMod);
        }

        dp = new long[n + 1][k + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        dp[0][k][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j][0] != Integer.MAX_VALUE) {
                    dp[i + 1][j][0] = Math.min(dp[i + 1][j][0], dp[i][j][0] + roadTime[i]);
                    if (j > 0) dp[i + 1][j - 1][1] = Math.min(dp[i + 1][j - 1][1], dp[i][j][0] + flightTime[i]);
                }
                if (dp[i][j][1] != Integer.MAX_VALUE) {
                    dp[i + 1][j][0] = Math.min(dp[i + 1][j][0], dp[i][j][1] + roadTime[i]);
                    dp[i + 1][j][1] = Math.min(dp[i + 1][j][1], dp[i][j][1] + flightTime[i]);
                }
            }
        }

        long res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) res = Math.min(res, Math.min(dp[n][i][0], dp[n][i][1]));
        return res;
    }
}
