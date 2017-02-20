package test.on2017_02.on2017_02_19_Codeforces_Round__260__Div__1_.A___Boredom;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    private static final int MAX = 100003;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] count = new int[MAX];
        for (int i = 0; i < n; i++) count[in.nextInt()]++;
        long[] dp = new long[MAX];
        dp[0] = 0;
        dp[1] = count[1];
        for (int i = 2; i < MAX; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (long) i * count[i]);
        }
        out.print(dp[MAX - 1]);
    }
}
