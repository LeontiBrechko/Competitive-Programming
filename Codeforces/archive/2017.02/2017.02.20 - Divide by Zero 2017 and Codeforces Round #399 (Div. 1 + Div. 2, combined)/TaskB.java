package tasks;

import lib.util.InputReader;
import test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.A___Santa_Claus_and_a_Place_in_a_Class.Main;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    long n, l, r;
    int res;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextLong();
        l = in.nextLong();
        r = in.nextLong();
        res = 0;
        nextLevel(n, 1, (long) (Math.pow(2, log2(n) + 1) - 1L));
        out.print(res);
    }

    private void nextLevel(long n, long left, long right) {
        if (n <= 1) {
            if (n == 1) res++;
            return;
        }

        long middle = (right + left) >>> 1;
        if (l < middle) nextLevel(n >>> 1, left, middle - 1);
        if (r > middle) nextLevel(n >>> 1, middle + 1, right);
        if (middle >= l && middle <= r && n % 2 == 1) res++;
    }

    private int log2(long n) {
        int res = 0;
        while (n >>> 1 > 0) {
            res++;
            n >>>= 1;
        }
        return res;
    }
}
