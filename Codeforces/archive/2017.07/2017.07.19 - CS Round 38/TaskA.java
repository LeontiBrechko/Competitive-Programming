package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] sizes = new int[2000][2];
        int nextSize, nextShoe;
        for (int i = 0; i < n; i++) {
            nextSize = in.nextInt();
            nextShoe = in.next().charAt(0) == 'L' ? 0 : 1;
            sizes[nextSize][nextShoe]++;
        }
        int res = 0;
        for (int i = 0; i < 2000; i++) {
            res += Math.min(sizes[i][0], sizes[i][1]);
        }
        out.print(res);
    }
}
