package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(k);
        LinkedList<Integer> children = new LinkedList<>();
        for (int i = 0; i < n; i++) children.add(i);

        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 0; i < k; i++) {
            j = (j + a[i]) % children.size();
            res.append(children.get(j) + 1).append(" ");
            children.remove(j);
        }
        out.print(res);
    }
}
