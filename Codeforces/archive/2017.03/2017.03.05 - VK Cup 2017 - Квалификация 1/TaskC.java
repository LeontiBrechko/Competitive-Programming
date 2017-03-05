package tasks;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int INF = Integer.MAX_VALUE / 2;
    private static final int[] ROW_DIRS = new int[] {1, 0, 0, -1};
    private static final int[] COL_DIRS = new int[] {0, -1, 1, 0};
    private static final char[] DIRS = new char[] {'D', 'L', 'R', 'U'};


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        boolean[][] grid = new boolean[n][m];
        int initRow = 0;
        int initCol = 0;
        int[][] distance = new int[n][m];

        String next;
        for (int i = 0; i < n; i++) {
            next = in.next();
            for (int j = 0; j < m; j++) {
                if (next.charAt(j) != '*') {
                    if (next.charAt(j) == 'X') {
                        initRow = i;
                        initCol = j;
                    }
                    grid[i][j] = true;
                }
                distance[i][j] = INF;
            }
        }

        if (k % 2 == 1) {
            out.print("IMPOSSIBLE");
            return;
        }

        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(initRow, initCol));
        distance[initRow][initCol] = 0;

        Position position;
        int nextRow, nextCol;
        while (!queue.isEmpty()) {
            position = queue.poll();

            for (int i = 0; i < 4; i++) {
                nextRow = position.row + ROW_DIRS[i];
                nextCol = position.column + COL_DIRS[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || !grid[nextRow][nextCol]) continue;

                if (distance[position.row][position.column] + 1 < distance[nextRow][nextCol]) {
                    distance[nextRow][nextCol] = distance[position.row][position.column] + 1;
                    queue.offer(new Position(nextRow, nextCol));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int currentRow = initRow;
        int currentCol = initCol;
        boolean isPossible;
        for (int i = 0; i < k; i++) {
            isPossible = false;
            for (int j = 0; j < 4 && !isPossible; j++) {
                nextRow = currentRow + ROW_DIRS[j];
                nextCol = currentCol + COL_DIRS[j];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || !grid[nextRow][nextCol]) continue;

                if (i + distance[nextRow][nextCol] < k) {
                    res.append(DIRS[j]);
                    currentRow = nextRow;
                    currentCol = nextCol;
                    isPossible = true;
                }
            }
            if (!isPossible) {
                out.print("IMPOSSIBLE");
                return;
            }
        }
        out.print(res);
    }

    private static class Position {
        int row;
        int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
