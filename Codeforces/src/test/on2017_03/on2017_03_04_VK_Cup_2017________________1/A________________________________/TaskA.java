package test.on2017_03.on2017_03_04_VK_Cup_2017________________1.A________________________________;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    private static final int MAX = 100001;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] count = new int[MAX];
        int current = 0;
        int max = 0;
        int next;
        for (int i = 0; i < 2 * n; i++) {
            next = in.nextInt();
            if (count[next] > 0) {
                current--;
            } else {
                count[next]++;
                current++;
            }
            max = Math.max(current, max);
        }
        out.print(max);
    }
}
