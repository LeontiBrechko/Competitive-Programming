package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int L = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);

        int[] temp = new int[n];
        boolean isPossible = false;
        boolean isSame;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = (b[j] + i) % L;
            }
            Arrays.sort(temp);
            isSame = true;
            for (int j = 0; j < n; j++) {
                if (temp[j] != a[j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                isPossible = true;
                break;
            }
        }

        out.print(isPossible ? "YES" : "NO");
    }
}
