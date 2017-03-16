package test.on2017_03.on2017_03_16_Codeforces_Round__344__Div__2_.A___My_Friend_of_Misery;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long max = Long.MAX_VALUE, min = 0, next;
        while (n-- > 0) {
            next = in.nextInt();
            if (in.next().charAt(0) == '-') max = Math.min(max, min + next + 25);
            else min += next + 25;
        }
        out.println(max - min);
    }
}
