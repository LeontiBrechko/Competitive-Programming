package test.on2017_03.on2017_03_16_Codeforces_Round__327__Div__2_.C___Median_Smoothing;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        boolean[] a = new boolean[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt() == 1;
        boolean[] isStatic = new boolean[n];
        isStatic[0] = isStatic[n - 1] = true;
        for (int i = 1; i < n - 1; i++) if (a[i] == a[i - 1] || a[i] == a[i + 1]) isStatic[i] = true;
        int[] distLeft = new int[n];
        int[] distRight = new int[n];
        for (int i = 0, j = -1; i < n; i++) {
            if (!isStatic[i]) distLeft[i] = i - j;
            else j = i;
        }
        for (int i = n - 1, j = n; i >= 0; i--) {
            if (!isStatic[i]) distRight[i] = j - i;
            else j = i;
        }
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, Math.min(distLeft[i], distRight[i]));
        out.println(res);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isStatic[i]) result.append(a[i] ? 1 : 0).append(' ');
            else if (distLeft[i] < distRight[i]) result.append(a[i - distLeft[i]] ? 1 : 0).append(' ');
            else result.append(a[i + distRight[i]] ? 1 : 0).append(' ');
        }
        out.print(result);
    }
}
