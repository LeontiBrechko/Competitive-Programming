package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        String n = in.next();
        int[] count = new int[10];
        int current = 0;
        for (int i = 0; i < n.length(); i++) {
            count[n.charAt(i) - '0']++;
            current += (n.charAt(i) - '0');
        }

        int res = 0;

        if (current < k) {
            int needed = k - current;
            int i = 0;
            while (i < 9 && needed > 0) {
                if (count[i] > 0) {
                    needed -= (9 - i);
                    count[i]--;
                    res++;
                } else {
                    i++;
                }
            }
        }

        out.print(res);
    }
}
