package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int k1 = (k - 1) / 2;
        out.printf("%d %d %c", k1 / m + 1, k1 % m + 1, k % 2 == 0 ? 'R' : 'L');
    }
}
