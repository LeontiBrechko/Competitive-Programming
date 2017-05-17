package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int next = n;
        int count = 0;
        while (next / 10 != 0) {
            next /= 10;
            count++;
        }
        next = (next + 1) * (int) Math.pow(10, count);
        out.print(next - n);
    }
}
