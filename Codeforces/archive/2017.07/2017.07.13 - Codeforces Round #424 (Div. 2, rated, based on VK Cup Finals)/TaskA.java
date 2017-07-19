package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int constNum = -1;
        boolean isUp = false;
        boolean foundConst = false;
        boolean isDown = false;

        boolean isTrue = true;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                if (constNum == -1) constNum = a[i];
                if (isDown || (constNum != a[i] && foundConst)) isTrue = false;
                foundConst = true;
            } else if (a[i] > a[i - 1]) {
                if (isDown || foundConst) isTrue = false;
                isUp = true;
            } else {
                if (!foundConst) {
                    if (constNum == -1) {
                        constNum = a[i - 1];
                        foundConst = true;
                    } else isTrue = false;
                }
                isDown = true;
            }
        }

        out.print(isTrue ? "YES" : "NO");
    }
}
