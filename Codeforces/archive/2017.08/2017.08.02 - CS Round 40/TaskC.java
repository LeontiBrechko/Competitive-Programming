package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        int[] isOn = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            isOn[i] = s.charAt(i) == '1' ? 1 : 0;
            r[i] = in.nextInt() - 1;
        }
        int[] c = in.nextIntArray(n);

        PriorityQueue<Integer> lowest = new PriorityQueue<>();
        long res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!lowest.isEmpty() && lowest.peek() < i) {
                lowest.poll();
                count--;
            }
            if ((isOn[i] + count) % 2 == 1) {
                count++;
                res = res + (long) c[i];
                lowest.offer(r[i]);
            }
        }

        out.print(res);
    }
}
