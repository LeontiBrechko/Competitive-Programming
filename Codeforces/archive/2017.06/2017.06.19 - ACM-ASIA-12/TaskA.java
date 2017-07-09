package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int num = in.nextInt();
        int p, q, x, y;
        int div;
        boolean isPrime;
        while (num > 0) {
            num--;

            p = in.nextInt();
            q = in.nextInt();
            isPrime = true;

            out: for (int m = -150; m <= 150; m++) {
                for (int n = -150; n <= 150; n++) {
                    div = m * m + n * n;
                    if (div <= 1 || (m == 1 && n == 0) || (m == 0 && n == 1) || (m == -1 && n == 0) || (m == -1) ||
                            (m == p && n == q) || (m == -q && n == p) || (m == -p && n == -q) || (m == q && n == -p))
                        continue;
                    x = m * p + n * q;
                    y = m * q - n * p;
                    if (x % div == 0 && y % div == 0) {
                        isPrime = false;
                        break out;
                    }
                }
            }

            out.println(isPrime ? 'P' : 'C');
        }
    }
}
