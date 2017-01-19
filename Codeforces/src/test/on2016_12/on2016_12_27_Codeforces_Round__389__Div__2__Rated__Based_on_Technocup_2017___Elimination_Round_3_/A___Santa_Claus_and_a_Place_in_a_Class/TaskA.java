package test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.A___Santa_Claus_and_a_Place_in_a_Class;





import lib.util.InputReader;

import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int k1 = (k - 1) / 2;
        out.printf("%d %d %c", k1 / m + 1, k1 % m + 1, k % 2 == 0 ? 'R' : 'L');
    }
}
