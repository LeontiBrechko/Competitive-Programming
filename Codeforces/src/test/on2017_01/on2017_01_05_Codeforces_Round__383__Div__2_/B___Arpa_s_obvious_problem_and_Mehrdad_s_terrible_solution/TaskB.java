package test.on2017_01.on2017_01_05_Codeforces_Round__383__Div__2_.B___Arpa_s_obvious_problem_and_Mehrdad_s_terrible_solution;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int numberCounts[] = new int[1 << 17];
        long res = 0;
        int nextNumber;
        for (int i = 0; i < n; i++) {
            nextNumber = in.nextInt();
            res += numberCounts[nextNumber ^ x];
            numberCounts[nextNumber]++;
        }
        out.print(res);
    }
}
