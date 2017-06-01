package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    int n, m, lastFloor;
    boolean[][] grid;
    int[] toTurnOff;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        grid = new boolean[n][m];
        toTurnOff = new int[n];
        lastFloor = 0;
        for (int i = n - 1; i >= 0; i--) {
            String next = in.next();
            for (int j = 0; j < m; j++) {
                if (next.charAt(j + 1) == '1') {
                    grid[i][j] = true;
                    toTurnOff[i]++;
                    if (i > lastFloor) lastFloor = i;
                }
            }
        }

        out.print(doIt(0, true));

    }

    private int doIt(int floor, boolean fromLeft) {
        if (floor == lastFloor + 1) return 0;

        if (toTurnOff[floor] == 0) {
            return doIt(floor + 1, fromLeft) + (floor + 1 > lastFloor ? 0 : 1);
        } else {
            int lastPosition = 0, res = 0;

            if (fromLeft) {
                for (int i = 0; i < m; i++) {
                    if (grid[floor][i]) lastPosition = i;
                }
                res = lastPosition + 1;
            } else {
                for (int i = m - 1; i >= 0; i--) {
                    if (grid[floor][i]) lastPosition = i;
                }
                res = m - lastPosition;
            }

            int res1 = doIt(floor + 1, true);
            if (fromLeft) {
                res1 += res;
                if (floor + 1 <= lastFloor) {
                    res1 += res;
                }
            } else {
                res1 += res;
                if (floor + 1 <= lastFloor) {
                    res1 += (lastPosition + 1);
                }
            }

            int res2 = doIt(floor + 1, false);
            if (fromLeft) {
                res2 += res;
                if (floor + 1 <= lastFloor) {
                    res2 += (m - lastPosition);
                }
            } else {
                res2 += res;
                if (floor + 1 <= lastFloor) {
                    res2 += res;
                }
            }

            res = Math.min(res1, res2) + (floor + 1 > lastFloor ? 0 : 1);
            return res;
        }
    }
}
