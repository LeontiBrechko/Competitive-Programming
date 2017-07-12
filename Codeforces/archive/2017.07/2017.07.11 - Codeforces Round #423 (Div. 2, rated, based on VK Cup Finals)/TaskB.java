package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int length = 1;
        int count = 0;
        boolean[][] grid = new boolean[n][m];

        String next;
        for (int i = 0; i < n; i++) {
            next = in.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = next.charAt(j) == 'B';
                count += grid[i][j] ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (grid[i][j] && grid[k][l])
                            length = Math.max(length, Math.max(Math.abs(i - k) + 1, Math.abs(j - l) + 1));
                    }
                }
            }
        }

        if (length > n || length > m) out.print(-1);
        else out.print(length * length - count);
    }
}
