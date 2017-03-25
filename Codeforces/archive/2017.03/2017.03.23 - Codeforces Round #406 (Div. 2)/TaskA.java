package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (b + a * i == d + c * j) {
                    out.print(b + a * i);
                    return;
                }
            }
        }
        out.print(-1);
    }
}
