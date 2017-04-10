package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class TaskB {
    String s;
    int[] n;
    int min;
    boolean[] shouldChange;
    StringBuilder res;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        s = in.next();
        n = new int[s.length()];
        shouldChange = new boolean[n.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = (s.charAt(i) - '0');
        }
        min = n[n.length - 1];
        for (int i = n.length - 2; i >= 0; i--) {
            if (n[i] > min) {
                shouldChange[i] = true;
                min = n[i] - 1;
            } else {
                min = Math.min(n[i], min);
            }
        }
        for (int i = 0; i < n.length; i++) {
            if (shouldChange[i]) {
                n[i]--;
                for (int j = i + 1; j < n.length; j++) {
                    n[j] = 9;
                }
                break;
            }
        }
        res = new StringBuilder();
        for (int i = n[0] == 0 ? 1 : 0; i < n.length; i++) {
            res.append(n[i]);
        }
        out.printf("Case #%d: %s\n", testNumber, res);
    }
}
