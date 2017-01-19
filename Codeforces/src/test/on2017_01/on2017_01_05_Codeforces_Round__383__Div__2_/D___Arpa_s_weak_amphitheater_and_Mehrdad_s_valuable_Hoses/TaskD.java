package test.on2017_01.on2017_01_05_Codeforces_Round__383__Div__2_.D___Arpa_s_weak_amphitheater_and_Mehrdad_s_valuable_Hoses;



import lib.WeightedQuickUnion;
import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n, m, w, groupdIndex;
        ;
        int[] ws;
        long[] b;
        long[][] dp;
        WeightedQuickUnion qu;
        HashMap<Integer, ArrayDeque<Integer>> groups = new HashMap<>();
        HashMap<Integer, Integer> weights = new HashMap<>();
        HashMap<Integer, Long> bs = new HashMap<>();

        n = in.nextInt();
        m = in.nextInt();
        w = in.nextInt();
        ws = new int[n];
        b = new long[n];
        for (int i = 0; i < n; i++) ws[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextLong();

        qu = new WeightedQuickUnion(n);
        for (int i = 0; i < m; i++) qu.uniteSites(in.nextInt() - 1, in.nextInt() - 1);
        int nextRoot;
        for (int i = 0; i < n; i++) {
            nextRoot = qu.findRoot(i);
            if (!groups.containsKey(nextRoot))
                groups.put(nextRoot, new ArrayDeque<>());
            groups.get(nextRoot).offer(i);
            weights.put(nextRoot, weights.getOrDefault(nextRoot, 0) + ws[i]);
            bs.put(nextRoot, bs.getOrDefault(nextRoot, 0L) + b[i]);
        }

        dp = new long[groups.keySet().size() + 1][w + 1];
        for (int i = 0; i < groups.keySet().size() + 1; i++) Arrays.fill(dp[i], -1);
        dp[0][w] = 0;
        groupdIndex = 0;
        for (Integer groupRoot : groups.keySet()) {
            for (int weight = 0; weight <= w; weight++) {
                if (dp[groupdIndex][weight] == -1) continue;
                dp[groupdIndex + 1][weight] = Math.max(dp[groupdIndex][weight], dp[groupdIndex + 1][weight]);
                if (weight - weights.get(groupRoot) >= 0)
                    dp[groupdIndex + 1][weight - weights.get(groupRoot)] =
                            Math.max(dp[groupdIndex][weight] + bs.get(groupRoot),
                                    dp[groupdIndex + 1][weight - weights.get(groupRoot)]);
                for (Integer girl : groups.get(groupRoot)) {
                    if (weight - ws[girl] >= 0)
                        dp[groupdIndex + 1][weight - ws[girl]] =
                                Math.max(dp[groupdIndex][weight] + b[girl] ,dp[groupdIndex + 1][weight - ws[girl]]);
                }
            }
            groupdIndex++;
        }

        long res = 0;
        for (int i = 0; i <= w; i++) if (dp[groups.keySet().size()][i] > res) res = dp[groups.keySet().size()][i];
        out.print(res);
    }

    private long getValue(long[][] dp, int index, int weight) {
        if (weight < 0) return Long.MIN_VALUE;
        if (weight == 0) return 0;
        if (index < 0) return 0;
        return dp[weight][index];
    }
}
