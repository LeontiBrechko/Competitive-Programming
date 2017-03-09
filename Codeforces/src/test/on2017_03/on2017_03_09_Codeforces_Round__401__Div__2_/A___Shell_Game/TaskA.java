package test.on2017_03.on2017_03_09_Codeforces_Round__401__Div__2_.A___Shell_Game;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        boolean[] game = new boolean[3];
        game[x] = true;

        while (!game[0] && n > 0) {
            if (n % 2 == 1) swap(game, 0, 1);
            else swap(game, 1, 2);
            n--;
        }

        n %= 6;
        while (n > 0) {
            if (n % 2 == 1) swap(game, 0, 1);
            else swap(game, 1, 2);
            n--;
        }

        for (int i = 0; i < 3; i++) {
            if (game[i]) {
                out.print(i);
                break;
            }
        }
    }

    private static void swap(boolean[] game, int i, int j) {
        boolean temp = game[i];
        game[i] = game[j];
        game[j] = temp;
    }
}
