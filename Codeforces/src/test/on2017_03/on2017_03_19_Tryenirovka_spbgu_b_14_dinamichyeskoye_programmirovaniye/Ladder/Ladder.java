package test.on2017_03.on2017_03_19_Tryenirovka_spbgu_b_14_dinamichyeskoye_programmirovaniye.Ladder;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Ladder {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        int k = in.nextInt();

        int[] dp = new int[n + 2];
        Arrays.fill(dp, -100000);
        dp[0] = 0;
        for (int i = 0; i < n + 2; i++) {
            for (int j = k; j > 0; j--) {
                if (i - j < 0) continue;
                dp[i] = Math.max(dp[i - j] + a[i], dp[i]);
            }
        }

        out.print(dp[n + 1]);
    }
}
