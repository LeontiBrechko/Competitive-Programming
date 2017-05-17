package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        Arrays.sort(a);
        int res = 1;
        int nextPos = Arrays.binarySearch(a, res);
        while (nextPos >= 0) {
            res++;
            nextPos = Arrays.binarySearch(a, res);
        }
        out.print(res);
    }
}
