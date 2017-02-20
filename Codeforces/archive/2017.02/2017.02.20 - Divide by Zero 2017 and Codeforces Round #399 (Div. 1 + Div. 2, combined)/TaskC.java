package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int MAX = 1024;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[][] a = new int[2][MAX];
        for (int i = 0; i < n; i++) {
            a[0][in.nextInt()]++;
        }
        int prev = 1;
        int next = 0;
        int xor;
        boolean fromFirst;
        for (int i = 0; i < k; i++) {
            prev ^= 1;
            next ^= 1;
            fromFirst = true;
            System.arraycopy(a[prev], 0, a[next], 0, a[0].length);
            for (int j = 0; j < MAX; j++) {
                if (a[prev][j] != 0) {
                    xor = j ^ x;
                    if (fromFirst) {
                        a[next][xor] += ((a[prev][j] + 1) / 2);
                        a[next][j] -= ((a[prev][j] + 1) / 2);
                    } else {
                        a[next][xor] += (a[prev][j] / 2);
                        a[next][j] -= (a[prev][j] / 2);
                    }
                    fromFirst = (a[prev][j] % 2 == 0) == fromFirst;
                }
            }
        }
        for (int i = MAX - 1; i >= 0; i--) {
            if (a[next][i] != 0) {
                out.print(i);
                break;
            }
        }
        for (int i = 0; i < MAX; i++) {
            if (a[next][i] != 0) {
                out.printf(" %d", i);
                break;
            }
        }
    }
}
