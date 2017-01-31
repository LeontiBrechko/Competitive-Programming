package test.on2017_01.on2017_01_31_Codeforces_Round__394__Div__2_.D___Dasha_and_Very_Difficult_Problem;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] p = new int[n];
        int[] pIndex = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt() - 1;
            pIndex[p[i]] = i;
        }

        int[] b = new int[n];
        b[pIndex[0]] = l;
        int cBase = l - a[pIndex[0]];
        int x;
        for (int i = 1; i < n; i++) {
            x = Math.max(l - a[pIndex[i]] - cBase, 1);
            b[pIndex[i]] = cBase + x + a[pIndex[i]];
            cBase += x;
        }

        boolean isPossible = true;
        for (int i = 0; i < n; i++) {
            if (b[i] > r) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            for (int i = 0; i < n; i++) out.printf("%d ", b[i]);
        } else out.print(-1);
    }
}
