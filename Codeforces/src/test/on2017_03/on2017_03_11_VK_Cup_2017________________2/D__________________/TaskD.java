package test.on2017_03.on2017_03_11_VK_Cup_2017________________2.D__________________;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        char[] brackets = in.next().toCharArray();
        int maxLevel = 0;
        int[] level = new int[n];
        int currentLevel = -1;
        int spaceNeeded = 0;
        for (int i = 0; i < n; i++) {
            if (brackets[i] == '[') level[i] = ++currentLevel;
            else level[i] = currentLevel--;
            maxLevel = Math.max(maxLevel, currentLevel);

            if (i > 0 && brackets[i] == ']' && brackets[i - 1] == '[') spaceNeeded++;
        }

        int rLength = maxLevel * 2 + 3;
        int cLength = spaceNeeded * 3 + n;
        char[][] result = new char[rLength][cLength];
        for (int i = 0; i < rLength; i++) Arrays.fill(result[i], ' ');

        boolean isNextLevel;
        for (int i = 0, column = 0; i < n; i++) {
            if (i > 0 && brackets[i] == ']' && brackets[i - 1] == '[') {
                fillSpace(result, column, level[i]);
                column += 3;
            }
            isNextLevel = (i > 0 && brackets[i] == '[' && brackets[i - 1] == '[') ||
                    (i < n - 1 && brackets[i] == ']' && brackets[i + 1] == ']');
            fillColumn(result, column++, level[i], isNextLevel);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                res.append(result[i][j]);
            }
            res.append("\n");
        }
        out.print(res);
    }

    private void fillColumn(char[][] grid, int column, int level, boolean isNextLevel) {
        int start = level;
        int end = grid.length - level;
        for (int i = start; i < end; i++) {
            if (i == start || i == end - 1) grid[i][column] = '+';
            else grid[i][column] = '|';
        }

        if (isNextLevel) {
            grid[start - 1][column] = grid[end][column] = '-';
        }
    }

    private void fillSpace(char[][] grid, int column, int level) {
        int end = grid.length - level - 1;
        grid[level][column] = grid[end][column] = grid[level][column + 2] = grid[end][column + 2] = '-';
    }
}
