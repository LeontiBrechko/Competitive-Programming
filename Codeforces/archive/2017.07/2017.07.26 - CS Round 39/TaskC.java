package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        int n = s.length();
        boolean[] add = new boolean[n - 1];
        for (int i = add.length - 1; i >= 0; i--) add[i] = in.nextInt() == 1;

        int nextRes;
        int currentCount;
        long res = 1;
        for (int i = n - 1; i >= 0; i--) {
            nextRes = s.charAt(i) - '0';
            if (i > 0 && add[i - 1]) nextRes += 10;
            if (i < n - 1 && add[i]) nextRes -= 1;
            currentCount = 0;

            if (nextRes < 0 || nextRes > 19) {
                res = 0;
                break;
            }

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j + k == nextRes) currentCount++;
                }
            }

            res *= ((long) currentCount);
        }

        out.print(res);
    }
}
