package test.on2017_03.on2017_03_29_Codeforces_Round__407__Div__2_.A___Anastasia_and_pebbles;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] w = new Integer[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }

        long res = 0;
        long next;
        boolean hasOneMore = true;
        for (int i = 0; i < n; i++) {
            if (w[i] >= k) {
                next = (long) Math.ceil((double) w[i] / k);
                if (next % 2 == 1) {
                    res += ((next - 1) / 2);
                    if (hasOneMore) hasOneMore = false;
                    else {
                        hasOneMore = true;
                        res++;
                    }
                } else {
                    res += (next / 2);
                }
            } else {
                if (hasOneMore) {
                    hasOneMore = false;
                } else {
                    hasOneMore = true;
                    res += 1;
                }
            }
        }

        if (!hasOneMore) res++;
        out.print(res);
    }
}
