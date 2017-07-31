package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = "v<^>";
        char first = in.next().charAt(0);
        char second = in.next().charAt(0);
        int n = in.nextInt();

        char l1 = a.charAt((a.indexOf(first) + n) % 4);
        char l2 = a.charAt((a.indexOf(first) - (n % 4) + 4) % 4);

        if (l1 == l2) out.print("undefined");
        else if (l1 == second) out.print("cw");
        else out.print("ccw");
    }
}
