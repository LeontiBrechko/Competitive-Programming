package test.on2017_03.on2017_03_15_Codeforces_Round__404__Div__2_.C___Anton_and_Fairy_Tale;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        long m = in.nextLong();

        if (n <= m) {
            out.print(n);
            return;
        }

        long sum = n - m - 1;

        long low = 0;
        long high = 1414213563L;
        long mid;
        long next;
        while (low < high) {
            mid = (low + high) >>> 1;
            if (mid % 2 == 0) {
                next = mid / 2;
                next *= (mid + 3);
            } else {
                next = (mid + 3) / 2;
                next *= mid;
            }
            if (sum > next) {
                low = mid + 1;
            } else high = mid;
        }

        out.print(m + high + 1);
    }
}
