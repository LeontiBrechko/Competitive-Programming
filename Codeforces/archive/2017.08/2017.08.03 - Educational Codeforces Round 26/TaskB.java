package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = in.nextCharTable(n, m);

        if (n % 3 == 0) {
            boolean isPossible = true;

            char[] colors = new char[3];
            colors[0] = grid[0][0];
            colors[1] = grid[n / 3][0];
            colors[2] = grid[n / 3 * 2][0];

            if (colors[0] == colors[1] || colors[1] == colors[2] || colors[0] == colors[2]) isPossible = false;

            for (int i = 0; i < 3 && isPossible; i++) {
                for (int j = n / 3 * i; j < n / 3 * (i + 1) && isPossible; j++) {
                    for (int k = 0; k < m && isPossible; k++) {
                        if (grid[j][k] != colors[i]) isPossible = false;
                    }
                }
            }

            if (isPossible) {
                out.print("YES");
                return;
            }
        }

        if (m % 3 == 0) {
            boolean isPossible = true;

            char[] colors = new char[3];
            colors[0] = grid[0][0];
            colors[1] = grid[0][m / 3];
            colors[2] = grid[0][m / 3 * 2];

            if (colors[0] == colors[1] || colors[1] == colors[2] || colors[0] == colors[2]) isPossible = false;

            for (int i = 0; i < 3 && isPossible; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = m / 3 * i; k < m / 3 * (i + 1); k++) {
                        if (grid[j][k] != colors[i]) isPossible = false;
                    }
                }
            }

            if (isPossible) {
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }
}
