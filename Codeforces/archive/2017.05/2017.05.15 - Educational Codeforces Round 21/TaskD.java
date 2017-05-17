package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        long sum = 0;
        long first = 0;
        HashSet<Long> half = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sum += a[i] = in.nextInt();
        }

        if (n == 1 || sum % 2 == 1 || (n == 2 && a[1] != a[0])) {
            out.print("NO");
            return;
        }

        int i;
        for (i = 0; i < n && first * 2 < sum; i++) {
            first += a[i];
            half.add(a[i]);
        }

        if (first * 2 > sum) {
            do {
                if (half.contains(first - (sum / 2))) {
                    out.print("YES");
                    return;
                }
                if (i < n) first += a[i];
                i++;
            } while (i < n);
            if (half.contains(first - (sum / 2))) {
                out.print("YES");
            } else {
                for (i = n - 1, first = 0, half.clear(); i >= 0 && first * 2 < sum; i--) {
                    first += a[i];
                    half.add(a[i]);
                }

                if (first * 2 > sum) {
                    do {
                        if (half.contains(first - (sum / 2))) {
                            out.print("YES");
                            return;
                        }
                        if (i >= 0) first += a[i];
                        i--;
                    } while (i >= 0);
                    if (half.contains(first - (sum / 2))) {
                        out.print("YES");
                    } else out.print("NO");
                }
            }
        } else out.print("YES");
    }
}
