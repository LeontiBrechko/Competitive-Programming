package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = 0;
        int res = 0;
        int next;
        while (n-- > 0) {
            next = in.nextInt();
            if (next == 1) {
                if (a > 0) a--;
                else if (b > 0) {
                    b--;
                    c++;
                }
                else if (c > 0) c--;
                else res++;
            } else {
                if (b > 0) b--;
                else res += 2;
            }
        }

        out.print(res);
    }
}
