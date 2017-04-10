package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        HashSet<Integer> holes = new HashSet<>();
        for (int i = 0; i < m; i++) {
            holes.add(in.nextInt());
        }
        int u, v;
        int current = 1;
        boolean isStuck = holes.contains(current);
        for (int i = 0; i < k; i++) {
            u = in.nextInt();
            v = in.nextInt();
            if (!isStuck) {
                if (current == u) {
                    current = v;
                    isStuck = holes.contains(current);
                } else if (current == v) {
                    current = u;
                    isStuck = holes.contains(current);
                }
            }
        }
        out.print(current);
    }
}
