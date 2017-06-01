package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    private static int inf = 10000;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        boolean[] has = new boolean[1001];
        for (int i = 0; i < n; i++) {
            has[in.nextInt()] = true;
        }

        int nextK, nextM, res = 0;
        for (int i = 1000; i >= k; i--) {
            nextK = k - 1;
            nextM = has[i] ? m : m - 1;
            for (int j = i - 1; j >= 1 && nextK > 0 && nextM >= 0; j--) {
                if (!has[j]) nextM--;
                nextK--;
            }
            if (nextK == 0 && nextM >= 0) {
                res++;
            }
        }
        out.print(res);
    }
}
