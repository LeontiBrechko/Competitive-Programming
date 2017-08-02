package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int c = in.nextInt();
        int[][][] stars = new int[101][101][c + 1];
        int[][][] single = new int[101][101][c + 1];

        int x, y, s;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            y = in.nextInt();
            s = in.nextInt();

            for (int j = 0; j <= c; j++)
                single[x][y][j] = stars[x][y][j] += ((s + j) % (c + 1));
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k <= c; k++) {
                    if (i > 0) stars[i][j][k] += stars[i - 1][j][k];
                    if (j > 0) stars[i][j][k] += stars[i][j - 1][k];
                    if (i > 0 && j > 0) stars[i][j][k] -= stars[i - 1][j - 1][k];
                }
            }
        }

        int t, x1, x2, y1, y2;
        while (q-- > 0) {
            t = in.nextInt();
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();

            t %= (c + 1);
            out.println(stars[x2][y2][t] - stars[x1 - 1][y2][t] - stars[x2][y1 - 1][t] + stars[x1 - 1][y1 - 1][t]);
        }
    }
}
