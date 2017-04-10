package test.on2017_04.on2017_04_09_Codeforces_Round__407__Div__2_.B___Masha_and_geometric_depression;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long b1 = in.nextInt();
        int q = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        HashSet<Long> a = new HashSet<>();
        for (int i = 0; i < m; i++) {
            a.add(in.nextLong());
        }

        if (Math.abs(b1) > l) out.print(0);
        else if (b1 == 0 || q == 1) {
            if (a.contains(b1)) out.print(0);
            else out.print("inf");
        } else if (q == -1) {
            if (a.contains(b1) && a.contains(-b1)) out.print(0);
            else out.print("inf");
        } else if (q == 0) {
            if (a.contains(0L)) {
                if (a.contains(b1)) out.print(0);
                else out.print(1);
            } else out.print("inf");
        } else {
            long res = 0;
            long b = b1;
            while (Math.abs(b) <= l) {
                if (!a.contains(b)) res++;
                b = b * (long) q;
            }
            out.print(res);
        }
    }
}
