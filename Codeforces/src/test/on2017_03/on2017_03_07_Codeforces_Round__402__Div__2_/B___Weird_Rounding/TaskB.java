package test.on2017_03.on2017_03_07_Codeforces_Round__402__Div__2_.B___Weird_Rounding;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String n = in.next();
        int k = in.nextInt();
        int res = 0;
        int i = n.length() - 1;
        while (i >= 0 && k > 0) {
            if (n.charAt(i) != '0') {
                res++;
            } else k--;
            i--;
        }

        if (k > 0 || (k == 0 && i == -1)) out.print(n.length() - 1);
        else out.print(res);
    }
}
