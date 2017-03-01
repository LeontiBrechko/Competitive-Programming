package test.on2017_02.on2017_02_28_Codeforces_Round__266__Div__2_.C___Number_of_Ways;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += ((long) a[i]);
        }

        if (sum % 3 != 0) out.print(0);
        else {
            long needed = sum / 3;
            int[] count = new int[n];
            long res = 0;
            sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                sum += ((long) a[i]);
                if (sum == needed) count[i] = 1;
            }
            for (int i = n - 2; i >= 0; i--) count[i] += count[i + 1];
            sum = 0;
            for (int i = 0; i + 2 < n; i++) {
                sum += ((long) a[i]);
                if (sum == needed) res += ((long) count[i + 2]);
            }
            out.print(res);
        }
    }
}
