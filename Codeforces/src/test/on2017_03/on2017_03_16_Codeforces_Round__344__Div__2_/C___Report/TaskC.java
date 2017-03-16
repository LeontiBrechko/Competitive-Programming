package test.on2017_03.on2017_03_16_Codeforces_Round__344__Div__2_.C___Report;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(n);
        ArrayDeque<Boolean> t = new ArrayDeque<>();
        ArrayDeque<Integer> r = new ArrayDeque<>();
        boolean nextT;
        int nextR;
        for (int i = 0; i < m; i++) {
            nextT = in.nextInt() == 2;
            nextR = in.nextInt();
            while (r.size() > 0 && nextR >= r.peekLast()) {
                t.pollLast();
                r.pollLast();
            }
            t.offer(nextT);
            r.offer(nextR);
        }

        int rMax = r.peek();
        Arrays.sort(a, 0, rMax);
        ArrayDeque<Integer> nextNumbers = new ArrayDeque<>();
        for (int i = 0; i < rMax; i++) nextNumbers.offer(a[i]);

        nextR = r.poll();
        nextT = t.poll();

        while (!r.isEmpty()) {
            while (nextR > r.peek()) {
                nextR--;
                if (!nextT) a[nextR] = nextNumbers.pollLast();
                else a[nextR] = nextNumbers.poll();
            }

            nextR = r.poll();
            nextT = t.poll();
        }

        while (nextR > 0) {
            nextR--;
            if (!nextT) a[nextR] = nextNumbers.pollLast();
            else a[nextR] = nextNumbers.poll();
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) res.append(a[i]).append(' ');
        out.print(res);
    }
}
