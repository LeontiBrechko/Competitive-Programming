package test.on2017_02.on2017_02_09_Codeforces_Round__396__Div__2_.B___Mahmoud_and_a_Triangle;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        boolean isPossible = false;
        for (int i = 0; i <= n - 3; i++) {
            if (a[i] + a[i + 1] > a[i + 2] &&
                    a[i] + a[i + 2] > a[i + 1] &&
                    a[i + 1] + a[i + 2] > a[i]) {
                isPossible = true;
                break;
            }
        }
        out.print(isPossible ? "YES" : "NO");
    }
}
