package test.on2017_01.on2017_01_31_Codeforces_Round__394__Div__2_.A___Dasha_and_Stairs;



import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        if ((a == b && a == 0) || Math.abs(a - b) > 1) out.print("NO");
        else out.print("YES");
    }
}
