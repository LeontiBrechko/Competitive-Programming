package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int current = 0;
        int max = 0;
        String s = in.readLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                max = Math.max(max, current);
                current = 0;
            } else if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                current++;
            }
        }

        max = Math.max(current, max);

        out.print(max);
    }
}
