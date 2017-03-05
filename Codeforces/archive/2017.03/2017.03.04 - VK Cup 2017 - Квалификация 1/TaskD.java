package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskD {
    private static final int MAX = 10001;
    private static final int DOUBLE_MAX = 20002;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] count = new int[MAX];
        for (int i = 0; i < n; i++) count[a[i] = in.nextInt()]++;

        int[] bitsCount = new int[DOUBLE_MAX];
        int numberNumber;
        for (int i = 0; i < DOUBLE_MAX; i++) {
            numberNumber = i;
            while (numberNumber > 0) {
                bitsCount[i] += (numberNumber & 1);
                numberNumber >>>= 1;
            }
        }

        long res = 0;
        int xor;
        for (int i = 0; i < MAX; i++) {
            if (count[i] >= 1) {
                for (int j = i; j < MAX; j++) {
                    if (count[j] >= 1) {
                        xor = i ^ j;
                        if (bitsCount[xor] == k) {
                            if (i == j) res += (((long) count[j] * (count[j] - 1)) / 2L);
                            else res += ((long) count[i] * count[j]);
                        }
                    }
                }
            }
        }
        out.print(res);
    }
}
