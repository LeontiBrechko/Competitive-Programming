package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[][] input = in.nextIntTable(4, 4);
        boolean isPossible = false;
        int k1, k2, k3;
        out: for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (input[i][j] == 1) {
                    k1 = i - 1;
                    k2 = i + 1;
                    k3 = i + 2;
                    if (k1 < 0) k1 += 4;
                    if (k2 > 3) k2 -= 4;
                    if (k3 > 3) k3 -= 4;

                    if (input[i][3] == 1 ||
                            (j == 0 && input[k1][3] == 1) ||
                            (j == 1 && input[k3][3] == 1) ||
                            (j == 2 && input[k2][3] == 1)) {
                        isPossible = true;
                        break out;
                    }
                }
            }
        }
        out.print(isPossible ? "YES" : "NO");
    }
}
