package test.on2017_04.on2017_04_10_Codeforces_Round__408__Div__2_.A___Buying_A_House;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt() - 1;
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        int res1 = -1;
        int res2 = -1;
        for (int i = m - 1; i >= 0; i--) {
            if (a[i] != 0 && a[i] <= k) {
                res1 = i;
                break;
            }
        }
        for (int i = m + 1; i < n; i++) {
            if (a[i] != 0 && a[i] <= k) {
                res2 = i;
                break;
            }
        }
        int res = res1 == -1 ? res2 - m : res2 == -1 ? m - res1 : Math.min(m - res1, res2 - m);
        out.print(res * 10);
    }
}
