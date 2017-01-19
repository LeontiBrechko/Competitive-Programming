package test.on2017_01.on2017_01_19_Codeforces_Round__392__Div__2_.C___Unfair_Poll;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;

        long grid[][] = new long[n][m];
        long cycles, max, min;
        if (n == 1) {
            cycles = k / m;
            k %= m;
        } else {
            cycles = k / (2L * m * (n - 1));
            k %= 2L * m * (n - 1);
        }
        for (int i = 0; i < m; i++) grid[0][i] = grid[n - 1][i] = cycles;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = cycles * 2L;
            }
        }
        for (int i = 0; k > 0 && i < n; i++) {
            for (int j = 0; k > 0 && j < m; j++, k--) {
                grid[i][j]++;
            }
        }
        for (int i = n - 2; k > 0 && i >= 1; i--) {
            for (int j = 0; k > 0 && j < m; j++, k--) {
                grid[i][j]++;
            }
        }
        max = -1;
        min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[i][j]);
                min = Math.min(min, grid[i][j]);
            }
        }
        out.printf("%d %d %d", max, min, grid[x][y]);
    }
}
