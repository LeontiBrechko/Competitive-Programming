package test.on2017_02.on2017_02_22_Codeforces_Round__316__Div__2_.A___Elections;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] max = new int[m][2];
        int[] winner = new int[n];
        int next;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                next = in.nextInt();
                if (max[i][0] < next) {
                    max[i][0] = next;
                    max[i][1] = j;
                }
            }
            winner[max[i][1]]++;
        }

        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (res[0] < winner[i]) {
                res[0] = winner[i];
                res[1] = i;
            }
        }
        out.print(res[1] + 1);
    }
}
