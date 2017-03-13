package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String x = in.next();
        int n = x.length();
        int[] currentDigits = new int[n];
        int[] res = new int[n];
        int resSum = 0;
        for (int i = 0; i < n; i++) resSum += currentDigits[i] = x.charAt(i) - '0';

        int currentSum = resSum;
        System.arraycopy(currentDigits, 0, res, 0, n);
        for (int i = n - 1; i > 0; i--) {
            if (currentDigits[i - 1] == 0) {
                currentSum = currentSum + (9 - currentDigits[i]);
                currentDigits[i] = 9;
            } else {
                currentSum = currentSum - 1 + (9 - currentDigits[i]);
                currentDigits[i] = 9;
                currentDigits[i - 1]--;
                if (currentSum > resSum) {
                    resSum = currentSum;
                    System.arraycopy(currentDigits, 0, res, 0, n);
                }
            }
        }

        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == 0 && res[i] == 0) continue;
            resultString.append(res[i]);
        }
        out.print(resultString);
    }
}
