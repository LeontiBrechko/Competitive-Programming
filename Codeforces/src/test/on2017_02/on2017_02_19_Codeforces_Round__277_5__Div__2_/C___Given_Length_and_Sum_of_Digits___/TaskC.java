package test.on2017_02.on2017_02_19_Codeforces_Round__277_5__Div__2_.C___Given_Length_and_Sum_of_Digits___;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskC {
    int m, s;
    int[][] dp;
    boolean isOk;
    StringBuilder res;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        m = in.nextInt();
        s = in.nextInt();

        if ((1 > s && m > 1) || m * 9 < s) {
            out.print("-1 -1");
            return;
        }

        dp = new int[m][s + 1];
        isOk = false;
        ArrayDeque<Integer> current = new ArrayDeque<>();

        for (int i = 1; i < 10; i++) {
            if (!isOk) {
                current.offer(i);
                nextMin(current, 1, i);
                current.pollLast();
            }
        }
        out.print(res == null ? 0 : res.toString());

        dp = new int[m][s + 1];
        isOk = false;
        for (int i = 9; i > 0; i--) {
            if (!isOk) {
                current.offer(i);
                nextMax(current, 1, i);
                current.pollLast();
            }
        }
        out.printf(" %s", res == null ? 0 : res.toString());
    }

    private void nextMin(ArrayDeque<Integer> current, int index, int sum) {
        if (index == m) {
            if (sum == s) {
                isOk = true;
                res = new StringBuilder();
                for (Integer i : current) res.append(i);
            }
            return;
        }
        if (sum > s) return;
        if (dp[index][sum] != 0) return;
        dp[index][sum] = sum;

        for (int i = 0; i < 10; i++) {
            if (!isOk) {
                current.offer(i);
                nextMin(current, index + 1, sum + i);
                current.pollLast();
            }
        }
    }

    private void nextMax(ArrayDeque<Integer> current, int index, int sum) {
        if (index == m) {
            if (sum == s) {
                isOk = true;
                res = new StringBuilder();
                for (Integer i : current) res.append(i);
            }
            return;
        }
        if (sum > s) return;
        if (dp[index][sum] != 0) return;
        dp[index][sum] = sum;

        for (int i = 9; i >= 0; i--) {
            if (!isOk) {
                current.offer(i);
                nextMax(current, index + 1, sum + i);
                current.pollLast();
            }
        }
    }
}
