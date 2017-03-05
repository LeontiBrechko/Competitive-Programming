package test.on2017_03.on2017_03_04_VK_Cup_2017________________1.C___________________;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    int n, m, k;
    boolean[][] grid;
    int initRow, initCol;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        grid = new boolean[n][m];

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
            }
        }

        if (k % 2 == 1) {
            out.print("IMPOSSIBLE");
            return;
        }

        int currentRow = initRow;
        int currentCol = initCol;
        int level = 0;
        StringBuilder res = new StringBuilder();

        while (level * 2 < k) {
            if (isValidDirection('D', currentRow, currentCol)) {
                res.append('D');
                currentRow++;
            } else if (isValidDirection('L', currentRow, currentCol)) {
                res.append('L');
                currentCol--;
            } else if (isValidDirection('R', currentRow, currentCol)) {
                res.append('R');
                currentCol++;
            } else if (isValidDirection('U', currentRow, currentCol)) {
                res.append('U');
                currentRow++;
            } else {
                out.print("IMPOSSIBLE");
                return;
            }
            level++;
        }

        String firstHalf = res.toString();
        StringBuilder secondHalf = new StringBuilder();
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            switch (firstHalf.charAt(i)) {
                case 'D':
                    secondHalf.append('U');
                    break;
                case 'U':
                    secondHalf.append('D');
                    break;
                case 'R':
                    secondHalf.append('L');
                    break;
                default:
                    secondHalf.append('R');
                    break;
            }
        }

        out.print(firstHalf);
        out.print(secondHalf);
    }

    private boolean isValidDirection(char direction, int row, int col) {
        int nextRow, nextCol;
        switch (direction) {
            case 'D':
                nextRow = row + 1;
                nextCol = col;
                break;
            case 'U':
                nextRow = row - 1;
                nextCol = col;
                break;
            case 'R':
                nextRow = row;
                nextCol = col + 1;
                break;
            default:
                nextRow = row;
                nextCol = col - 1;
                break;
        }

        return nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && grid[nextRow][nextCol];
    }
}
