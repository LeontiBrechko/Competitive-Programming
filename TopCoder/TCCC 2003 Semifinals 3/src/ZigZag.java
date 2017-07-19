import java.util.Arrays;

public class ZigZag {

    public int longestZigZag(int[] sequence) {
        int n = sequence.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) dp[i][0] = dp[i][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sequence[j] > sequence[i]) {
                    dp[j][1] = Math.max(dp[j][1], dp[i][0] + 1);
                } else if (sequence[j] < sequence[i]) {
                    dp[j][0] = Math.max(dp[j][0], dp[i][1] + 1);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        return res;
    }
}
