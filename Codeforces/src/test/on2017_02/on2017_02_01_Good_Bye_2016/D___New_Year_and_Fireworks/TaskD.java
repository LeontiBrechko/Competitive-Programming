package test.on2017_02.on2017_02_01_Good_Bye_2016.D___New_Year_and_Fireworks;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class TaskD {
    private final int[] xDirs = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    private final int[] yDirs = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
    private final int MAX = 310;

    private int n;
    private int[] t;
    private boolean[][][][] dp;
    private boolean[][] points;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        t = in.nextIntArray(n);
        dp = new boolean[MAX][MAX][8][30];
        points = new boolean[MAX][MAX];
        go(MAX / 2, MAX / 2, 0, 0);
        int res = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (points[i][j]) res++;
            }
        }
        out.print(res);
    }

    private void go(int x, int y, int direction, int level) {
        if (level == n) return;
        if (dp[x][y][direction][level]) return;
        else dp[x][y][direction][level] = true;
        int nextX = x, nextY = y;
        for (int i = 0; i < t[level]; i++) {
            nextX = x + xDirs[direction] * i;
            nextY = y + yDirs[direction] * i;
            points[nextX][nextY] = true;
        }

        int nextDir = (direction + 1) % 8;
        go(nextX + xDirs[nextDir], nextY + yDirs[nextDir], nextDir, level + 1);
        nextDir = (direction + 7) % 8;
        go(nextX + xDirs[nextDir], nextY + yDirs[nextDir], nextDir, level + 1);
    }
}
