package test.on2017_01.on2017_01_25_Educational_Codeforces_Round_17.A___k_th_divisor1;





import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        int k = in.nextInt();
        TreeSet<Long> factors = new TreeSet<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        if (factors.size() < k) out.print(-1);
        else {
            for (Long i : factors) {
                if (--k == 0) {
                    out.print(i);
                    break;
                }
            }
        }
    }
}
