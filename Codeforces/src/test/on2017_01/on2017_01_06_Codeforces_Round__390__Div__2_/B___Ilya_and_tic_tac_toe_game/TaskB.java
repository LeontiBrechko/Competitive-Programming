package test.on2017_01.on2017_01_06_Codeforces_Round__390__Div__2_.B___Ilya_and_tic_tac_toe_game;



import lib.util.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[][] grid = new char[4][4];
        String line;
        for (int i = 0; i < 4; i++) {
            line = in.next();
            for (int j = 0; j < 4; j++)
                grid[i][j] = line.charAt(j);
        }

        boolean isPossible = false;
        boolean isUsed = false;
        out: for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 'x' || grid[i][j] == '.') {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (k == 0 && l == 0) continue;
                            if (i + 2 * k >= 0 && i + 2 * k < 4 && j + 2 * l >= 0 && j + 2 * l < 4) {
                                isUsed = grid[i][j] == '.';
                                isPossible = true;

                                if (grid[i + k][j + l] == '.' && !isUsed) isUsed =  true;
                                else if (grid[i + k][j + l] != 'x') isPossible = false;
                                if (grid[i + 2 * k][j + 2 * l] == '.' && !isUsed) isUsed = true;
                                else if (grid[i + 2 * k][j + 2 * l] != 'x') isPossible = false;

                                if (isPossible)
                                    break out;
                            }
                        }
                    }
                }
            }
        }

        out.print(isPossible ? "YES" : "NO");
    }
}
