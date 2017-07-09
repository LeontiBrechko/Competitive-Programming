package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] g = in.nextIntTable(n, m);
        int[][] g1 = new int[n][m];
        for (int i = 0; i < n; i++) System.arraycopy(g[i], 0, g1[i], 0, m);

        int min;
        int k = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) min = Math.min(min, g[i][j]);
            if (min > 0) {
                for (int j = 0; j < m; j++) g[i][j] -= min;
                for (int j = 0; j < min; j++) {
                    res.append("row ").append(i + 1).append('\n');
                    k++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) min = Math.min(min, g[j][i]);
            if (min > 0) {
                for (int j = 0; j < n; j++) g[j][i] -= min;
                for (int j = 0; j < min; j++) {
                    res.append("col ").append(i + 1).append('\n');
                    k++;
                }
            }
        }

        int k1 = 0;
        StringBuilder res1 = new StringBuilder();
        for (int i = 0; i < m; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) min = Math.min(min, g1[j][i]);
            if (min > 0) {
                for (int j = 0; j < n; j++) g1[j][i] -= min;
                for (int j = 0; j < min; j++) {
                    res1.append("col ").append(i + 1).append('\n');
                    k1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) min = Math.min(min, g1[i][j]);
            if (min > 0) {
                for (int j = 0; j < m; j++) g1[i][j] -= min;
                for (int j = 0; j < min; j++) {
                    res1.append("row ").append(i + 1).append('\n');
                    k1++;
                }
            }
        }

        boolean isOk = true;
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (k < k1 ? g[i][j] != 0 : g1[i][j] != 0) {
                    isOk = false;
                    break out;
                }
            }
        }

        out.print(!isOk ? -1 : String.format("%d\n%s", k < k1 ? k : k1, k < k1 ? res.toString() : res1.toString()));
    }
}
