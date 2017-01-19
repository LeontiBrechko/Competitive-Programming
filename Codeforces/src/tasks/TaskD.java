package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        String k = in.next();
        long res = 0;
        long next = -1;
        int j, z, power = 0;
        String nextSub;
        for (int i = k.length() - 1; i >= 0;) {
            j = i;
            while (j >= 0 && (next = Long.parseLong(k.substring(j, i + 1))) < n)
                j--;
            if (next >= n) {
                nextSub = k.substring(Math.min(j + 1, i), i + 1);
                next = Long.parseLong(nextSub);
                z = 0;
                while (z < nextSub.length() && nextSub.charAt(z) == '0') {
                    j++;
                    z++;
                    next = Long.parseLong(k.substring(Math.min(j + 1, i), i + 1));
                }
                if (next == 0) i--;
                else i = Math.min(i, j);
            } else if (next == 0) {
                i--;
            } else i = j - 1;
            res += (Math.pow(n, power) * next);
            power++;
        }
        out.print(res);
    }
}
