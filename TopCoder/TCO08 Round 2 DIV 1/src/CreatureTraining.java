import java.util.Arrays;

public class CreatureTraining {
    long[][][] dp;
    int n, d;
    int[] count, power;

    public long maximumPower(int[] count, int[] power, int D) {
        this.count = count;
        this.power = power;
        n = count.length;
        d = D;
        dp = new long[n][d + 1][d + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= d; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return train(0, 0, d);
    }

    private long train(int level, int numberTrained, int daysLeft) {
        if (level == n) return 0;
        if (dp[level][numberTrained][daysLeft] > -1) return dp[level][numberTrained][daysLeft];

        long res = 0;
        long current, next;
        int maxToTrain = Math.min(daysLeft, count[level] + numberTrained);
        for (int i = 0; i <= maxToTrain; i++) {
            current = power[level] * (count[level] + numberTrained - i);
            next = train(level + 1, i, daysLeft - i);
            res = Math.max(res, current + next);
        }

        return dp[level][numberTrained][daysLeft] = res;
    }
}
