import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class StepsConstruct {
    private static final int INF = Integer.MAX_VALUE;

    int[][] steps;
    char[][] directions;
    int n, m;
    ArrayDeque<Character> res;

    public String construct(String[] board, int k) {
        n = board.length;
        m = board[0].length();
        steps = new int[n][m];
        directions = new char[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(steps[i], INF);
        steps[0][0] = 0;
        bfs(0, 0, board);
        if (board[0].charAt(0) == '.' && directions[n - 1][m - 1] != '\u0000' && k >= steps[n - 1][m - 1]) {
            k -= steps[n - 1][m - 1];
            if (k % 2 == 1) return "";
            else {
                res = new ArrayDeque<>();
                getRes(n - 1, m - 1);
                StringBuilder result = new StringBuilder();
                String stringToAdd = directions[n - 1][m - 1] == 'D' ? "UD" : "LR";
                for (Character i : res) result.append(i);
                while (k > 0) {
                    result.append(stringToAdd);
                    k -= 2;
                }
                return result.toString();
            }
        } else return "";
    }

    private void bfs(int i, int j, String[] board) {
        if (i - 1 >= 0 && board[i - 1].charAt(j) == '.') {
            if (steps[i][j] + 1 < steps[i - 1][j]) {
                steps[i - 1][j] = steps[i][j] + 1;
                directions[i - 1][j] = 'U';
                bfs(i - 1, j, board);
            }
        }
        if (i + 1 < n && board[i + 1].charAt(j) == '.') {
            if (steps[i][j] + 1 < steps[i + 1][j]) {
                steps[i + 1][j] = steps[i][j] + 1;
                directions[i + 1][j] = 'D';
                bfs(i + 1, j, board);
            }
        }
        if (j - 1 >= 0 && board[i].charAt(j - 1) == '.') {
            if (steps[i][j] + 1 < steps[i][j - 1]) {
                steps[i][j - 1] = steps[i][j] + 1;
                directions[i][j - 1] = 'L';
                bfs(i, j - 1, board);
            }
        }
        if (j + 1 < m && board[i].charAt(j + 1) == '.') {
            if (steps[i][j] + 1 < steps[i][j + 1]) {
                steps[i][j + 1] = steps[i][j] + 1;
                directions[i][j + 1] = 'R';
                bfs(i, j + 1, board);
            }
        }
    }

    private void getRes(int x, int y) {
        switch (directions[x][y]) {
            case 'U':
                res.push(directions[x][y]);
                getRes(x + 1, y);
                break;
            case 'D':
                res.push(directions[x][y]);
                getRes(x - 1, y);
                break;
            case 'L':
                res.push(directions[x][y]);
                getRes(x, y + 1);
                break;
            case 'R':
                res.push(directions[x][y]);
                getRes(x, y - 1);
                break;
            default:
                break;
        }
    }
}
