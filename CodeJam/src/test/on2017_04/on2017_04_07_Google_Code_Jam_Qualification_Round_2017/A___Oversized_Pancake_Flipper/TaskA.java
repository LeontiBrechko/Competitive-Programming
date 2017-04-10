package test.on2017_04.on2017_04_07_Google_Code_Jam_Qualification_Round_2017.A___Oversized_Pancake_Flipper;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    String s;
    int k, n;
    long res;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        s = in.next();
        k = in.nextInt();
        n = s.length();

        res = Math.min(tryIt(true), tryIt(false));

        if (res != Long.MAX_VALUE) out.printf("Case #%d: %d\n", testNumber, res);
        else out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
    }

    private long tryIt(boolean fromStart) {
        boolean isPossible = true;
        boolean[] isHappy = new boolean[n];
        long res = 0;

        for (int i = 0; i < n; i++) isHappy[i] = s.charAt(i) == '+';
        for (int i = fromStart ? 0 : n - 1;
             fromStart ? (i < n && i + k <= n) : (i >= 0 && i - k + 1 >= 0);
             i += (fromStart ? 1 : -1)) {
            if (!isHappy[i]) {
                res++;
                for (int j = 0; j < k; j++) {
                    if (fromStart) isHappy[i + j] = !isHappy[i + j];
                    else isHappy[i - j] = !isHappy[i - j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isHappy[i]) {
                isPossible = false;
                break;
            }
        }
        return isPossible ? res : Long.MAX_VALUE;
    }
}
