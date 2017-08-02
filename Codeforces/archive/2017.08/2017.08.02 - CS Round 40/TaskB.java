package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int r1 = in.nextInt();
        int c1 = in.nextInt();
        int r2 = in.nextInt();
        int c2 = in.nextInt();

        if ((r1 + c1) % 2 != (r2 + c2) % 2) out.print(-1);
        else if (r1 == r2 && c1 == c2) out.print(0);
        else if (r1 - c1 == r2 - c2 || r1 + c1 == r2 + c2) out.print(1);
        else out.print(2);

    }
}
