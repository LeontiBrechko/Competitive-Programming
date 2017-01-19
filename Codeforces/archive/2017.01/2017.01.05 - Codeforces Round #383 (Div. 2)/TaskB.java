package tasks;

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
