package tasks;



import lib.util.InputReader;
import java.io.PrintWriter;

public class Where_is_the_Marble {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();
        int a, b;
        for (int i = 0; i < n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            if (a == m) m = b;
            else if (b == m) m = a;
        }
        out.print(m);
    }
}
