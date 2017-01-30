package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        ArrayDeque<Integer> res = new ArrayDeque<>();
        int next = 1;
        while (n >= next) {
            res.offer(next);
            n -= next;
            next++;
        }
        if (res.size() > 0) {
            res.offer(res.pollLast() + n);
        } else res.offer(n);
        out.println(res.size());
        for (Integer i : res) {
            out.printf("%d ", i);
        }
    }
}
