package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        String a = in.next();
        String b = in.next();
        int resCount = Integer.MAX_VALUE;
        int currentCount;
        StringBuilder res = null;
        StringBuilder currentRes;
        for (int i = 0; i + n <= m; i++) {
            currentCount = 0;
            currentRes = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    currentCount++;
                    currentRes.append(j + 1).append(' ');
                }
            }
            if (currentCount < resCount) {
                res = currentRes;
                resCount = currentCount;
            }
        }

        out.printf("%d\n%s", resCount, res);
    }
}
