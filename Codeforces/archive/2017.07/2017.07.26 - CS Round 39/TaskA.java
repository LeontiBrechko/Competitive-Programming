package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] pages = in.nextIntArray(n);
        boolean[] visited = new boolean[200000];

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[pages[i]]) res++;
            visited[pages[i]] = true;
            visited[pages[i] % 2 == 1 ? pages[i] + 1 : pages[i] - 1] = true;
        }

        out.print(res);
    }
}
