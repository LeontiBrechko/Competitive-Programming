package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String queue = in.next();

        int[] open = new int[26];
        int[] close = new int[26];
        Arrays.fill(open, -1);
        Arrays.fill(close, -1);

        char next;
        for (int i = 0; i < n; i++) {
            next = queue.charAt(i);
            if (open[next - 'A'] == -1) open[next - 'A'] = i;
            close[next - 'A'] = i;
        }

        int numberOpened = 0;
        for (int i = 0; i < n; i++) {
            next = queue.charAt(i);
            if (open[next - 'A'] == i) numberOpened++;

            if (numberOpened > k) {
                out.print("YES");
                return;
            }

            if (close[next - 'A'] == i) numberOpened--;
        }

        out.print("NO");
    }
}
