package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int INF = Integer.MAX_VALUE / 4;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] strings = new char[n][m];
        for (int i = 0; i < n; i++) strings[i] = in.next().toCharArray();

        int[][] info = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(info[i], INF);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strings[i][j] >= '0' && strings[i][j] <= '9')
                    info[i][0] = Math.min(info[i][0], Math.min(j, m - j));
                else if (strings[i][j] >= 'a' && strings[i][j] <= 'z')
                    info[i][1] = Math.min(info[i][1], Math.min(j, m - j));
                else info[i][2] = Math.min(info[i][2], Math.min(j, m - j));
            }
        }

        int res = INF;
        int currentRes;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    currentRes = info[i][0] + info[j][1] + info[k][2];
                    if (i == j || j == k || i == k) currentRes = INF;
                    res = Math.min(currentRes, res);
                }
            }
        }

        out.print(res);
    }
}
