package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int fac = Math.min(a, b);
        long res = 1;
        for (int i = 1; i <= fac; i++) res *= ((long) i);
        out.print(res);
    }
}
