package test.on2017_03.on2017_03_01_Codeforces_Round__272__Div__2_.B___Dreamoon_and_WiFi;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    int truePos, falsePos, count, length, res;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        truePos = falsePos = count = res = 0;
        String s = in.next();
        length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '+') truePos++;
            else truePos--;
        }
        s = in.next();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '?') count++;
            else if (s.charAt(i) == '+') falsePos++;
            else falsePos--;
        }
        if (count == 0) {
            out.print(truePos == falsePos ? 1.0 : 0.0);
        } else {
            next(falsePos - 1, count - 1);
            next(falsePos + 1, count - 1);
            out.printf("%.12f", (double) res / Math.pow(2, count));
        }
    }

    private void next(int i, int count) {
        if (count == 0) {
            if (i == truePos) res++;
            return;
        }
        next(i + 1, count - 1);
        next(i - 1, count - 1);
    }
}
