package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        if ((a == b && a == 0) || Math.abs(a - b) > 1) out.print("NO");
        else out.print("YES");
    }
}
