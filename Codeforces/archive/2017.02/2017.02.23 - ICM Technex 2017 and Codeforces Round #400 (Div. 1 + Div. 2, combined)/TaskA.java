package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String[] names = new String[2];
        names[0] = in.next();
        names[1] = in.next();
        int n = in.nextInt();
        StringBuilder res = new StringBuilder();
        res.append(names[0]).append(" ").append(names[1]).append("\n");
        String[] next = new String[2];
        for (int i = 0; i < n; i++) {
            next[0] = in.next();
            next[1] = in.next();
            if (names[0].equals(next[0])) names[0] = next[1];
            else names[1] = next[1];
            res.append(names[0]).append(" ").append(names[1]).append("\n");
        }
        out.print(res);
    }
}
