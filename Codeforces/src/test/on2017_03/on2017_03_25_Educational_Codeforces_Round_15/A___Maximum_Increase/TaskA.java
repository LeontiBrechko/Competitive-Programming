package test.on2017_03.on2017_03_25_Educational_Codeforces_Round_15.A___Maximum_Increase;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int res = 1;

        for (int i = 1, j = 1; i <= n; i++) {
            if (i == n) {
                res = Math.max(j, res);
                break;
            }

            if (a[i] > a[i - 1]) j++;
            else {
                res = Math.max(j, res);
                j = 1;
            }
        }

        out.print(res);
    }
}
