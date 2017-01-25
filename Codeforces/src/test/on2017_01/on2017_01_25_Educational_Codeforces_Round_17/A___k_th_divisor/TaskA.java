package test.on2017_01.on2017_01_25_Educational_Codeforces_Round_17.A___k_th_divisor;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        int k = in.nextInt();
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        Collections.sort(factors);
        if (factors.size() < k) out.print(-1);
        else out.print(factors.get(k - 1));
    }
}
