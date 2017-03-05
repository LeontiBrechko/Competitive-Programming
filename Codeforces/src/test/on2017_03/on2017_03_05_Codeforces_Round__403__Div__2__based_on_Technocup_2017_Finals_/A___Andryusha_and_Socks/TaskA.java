package test.on2017_03.on2017_03_05_Codeforces_Round__403__Div__2__based_on_Technocup_2017_Finals_.A___Andryusha_and_Socks;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        out.print(a[n / 2]);
    }
}
