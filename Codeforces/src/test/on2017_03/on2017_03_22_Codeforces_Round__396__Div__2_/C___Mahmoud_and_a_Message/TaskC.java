package test.on2017_03.on2017_03_22_Codeforces_Round__396__Div__2_.C___Mahmoud_and_a_Message;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        int[] a = in.nextIntArray(26);

        int[] dp = new int[n + 1];
        dp[0] = 1;
        int l, max;
        max = 0;
        for (int i = 1; i <= n; i++) {
            l = a[s[i - 1] - 'a'];
            for (int count = 1, x = i - 1; count <= l && x >= 0; count++, x--) {
                dp[i] = (dp[i] + dp[x]) % MOD;
                max = Math.max(max, count);
                if(x > 0) l = Math.min(a[s[x - 1] - 'a'], l);
            }
        }

        int min = 0;
        for (int i = 0, j = 0; i < n; ) {
            l = i + a[s[i] - 'a'] - 1;
            while (j < n && j <= l) {
                j++;
                if (j < n) l = Math.min(l, i + a[s[j] - 'a'] - 1);
            }
            min++;
            i = j;
        }

        out.println(dp[n]);
        out.println(max);
        out.print(min);
    }
}
