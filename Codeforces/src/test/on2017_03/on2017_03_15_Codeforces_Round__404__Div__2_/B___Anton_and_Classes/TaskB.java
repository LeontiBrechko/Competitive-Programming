package test.on2017_03.on2017_03_15_Codeforces_Round__404__Div__2_.B___Anton_and_Classes;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int firstMaxStart = -1, firstMinFinish = Integer.MAX_VALUE;
        int l, r;
        for (int i = 0; i < n; i++) {
            l = in.nextInt();
            r = in.nextInt();
            if (r < firstMinFinish) firstMinFinish = r;
            if (l > firstMaxStart) firstMaxStart = l;
        }
        int m = in.nextInt();
        int secondMaxStart = -1, secondMinFinish = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            l = in.nextInt();
            r = in.nextInt();
            if (r < secondMinFinish) secondMinFinish = r;
            if (l > secondMaxStart) secondMaxStart = l;
        }

        int res = 0;
        if (firstMinFinish < secondMaxStart) res = secondMaxStart - firstMinFinish;
        if (secondMinFinish < firstMaxStart) res = Math.max(res, firstMaxStart - secondMinFinish);
        out.print(res);
    }
}
