package test.on2017_03.on2017_03_23_Codeforces_Round__406__Div__2_.C___Berzerk;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskC {
    int n;
    int[][] k, dp, count;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = new int[2][];
        k[0] = new int[in.nextInt()];
        for (int i = 0; i < k[0].length; i++) k[0][i] = in.nextInt();
        k[1] = new int[in.nextInt()];
        for (int i = 0; i < k[1].length; i++) k[1][i] = in.nextInt();

        dp = new int[2][n];
        count = new int[2][n];
        dp[0][0] = dp[1][0] = -1;
        dfs(0, 0);
        dfs(1, 0);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < n; j++) {
                switch (dp[i][j]) {
                    case -1:
                        res.append("Lose ");
                        break;
                    case 0:
                        res.append("Loop ");
                        break;
                    case 1:
                        res.append("Win ");
                        break;
                }
            }
            res.append("\n");
        }

        out.print(res);
    }

    private void dfs(int turn, int planet) {
        int previousPlanet;
        if (dp[turn][planet] == -1) {
            turn ^= 1;
            for (int i = 0; i < k[turn].length; i++) {
                previousPlanet = planet - k[turn][i];
                if (previousPlanet < 0) previousPlanet += n;
                if (dp[turn][previousPlanet] == 0) {
                    dp[turn][previousPlanet] = 1;
                    dfs(turn, previousPlanet);
                }
            }
        } else {
            turn ^= 1;
            for (int i = 0; i < k[turn].length; i++) {
                previousPlanet = planet - k[turn][i];
                if (previousPlanet < 0) previousPlanet += n;
                count[turn][previousPlanet]++;
                if (dp[turn][previousPlanet] == 0 && count[turn][previousPlanet] == k[turn].length) {
                    dp[turn][previousPlanet] = -1;
                    dfs(turn, previousPlanet);
                }
            }
        }
    }
}
