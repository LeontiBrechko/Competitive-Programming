package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        int[] c = new int[n];

        int diffCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) diffCount++;
        }

        boolean[] p = new boolean[n + 1];
        if (diffCount == 1) {
            int toReplace = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i]) {
                    c[i] = a[i];
                    p[a[i]] = true;
                } else {
                    toReplace = i;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (!p[i] && a[toReplace] != i && b[toReplace] != i) {
                    c[toReplace] = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                out.printf("%d ", c[i]);
            }
        } else {
            boolean isDone = false;
            int toReplace1 = -1;
            int toReplace2 = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i]) {
                    c[i] = a[i];
                    p[a[i]] = true;
                } else {
                    if (toReplace1 == -1) {
                        toReplace1 = i;
                    } else {
                        toReplace2 = i;
                    }
                }
            }
            if (a[toReplace1] != b[toReplace2] && !p[a[toReplace1]] && !p[b[toReplace2]]) {
                c[toReplace1] = a[toReplace1];
                c[toReplace2] = b[toReplace2];
            } else {
                c[toReplace1] = b[toReplace1];
                c[toReplace2] = a[toReplace2];
            }
            for (int i = 0; i < n; i++) {
                out.printf("%d ", c[i]);
            }
        }
    }
}
