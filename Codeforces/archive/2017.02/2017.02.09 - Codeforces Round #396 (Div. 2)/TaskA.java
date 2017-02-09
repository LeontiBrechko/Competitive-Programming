package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        if (a.length != b.length) out.print(Math.max(a.length, b.length));
        else {
            boolean isSame = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    isSame = false;
                    break;
                }
            }
            out.print(isSame ? -1 : a.length);
        }
    }
}
