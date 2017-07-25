package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        out.print((n / k) % 2 == 1 ? "YES" : "NO");
    }
}
