package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    private int max;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        boolean[] isNotPrime = new boolean[n];
        long nextCost;
        boolean hasPrime = false;
        boolean hasNotPrime = false;
        for (int i = 0; i < n; i++) {
            if (!isNotPrime[i]) {
                nextCost = i + 2;
                if (!hasPrime) hasPrime = true;
                for (long j = nextCost * nextCost; j < n + 2; j += nextCost) {
                    isNotPrime[(int) (j - 2)] = true;
                    if (!hasNotPrime) hasNotPrime = true;
                }
            }
        }

        int k = hasPrime ? 1 : 0;
        k += (hasNotPrime ? 1 : 0);
        out.println(k);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(isNotPrime[i] ? 2 : 1).append(" ");
        }
        out.print(res);
    }
}
