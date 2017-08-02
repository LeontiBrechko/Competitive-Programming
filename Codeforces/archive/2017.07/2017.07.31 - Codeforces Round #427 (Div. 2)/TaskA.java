package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int s = in.nextInt();
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        int t1 = in.nextInt();
        int t2 = in.nextInt();

        long res1 = (long) s * v1 + t1 + t1;
        long res2 = (long) s * v2 + t2 + t2;
        out.print(res1 > res2 ? "Second" : res1 < res2 ? "First" : "Friendship");
    }
}
