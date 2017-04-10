package test.on2017_04.on2017_04_10_Codeforces_Round__408__Div__2_.C___Bank_Hacking;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        PriorityQueue<Bank> banks = new PriorityQueue<>();
        ArrayDeque<Integer>[] toDetermine = new ArrayDeque[2];
        toDetermine[0] = new ArrayDeque<>();
        toDetermine[1] = new ArrayDeque<>();
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            banks.offer(new Bank(i, a[i]));
            adj[i] = new HashSet<>();
            toDetermine[0].offer(i);
        }

        int u, v;
        int[] bankMaxOne = new int[n];
        int[] bankMaxTwo = new int[n];
        Arrays.fill(bankMaxOne, Integer.MIN_VALUE);
        Arrays.fill(bankMaxTwo, Integer.MIN_VALUE);
        for (int i = 1; i < n; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            bankMaxOne[u] = Math.max(bankMaxOne[u], a[v]);
            bankMaxOne[v] = Math.max(bankMaxOne[v], a[u]);
            adj[u].add(v);
            adj[v].add(u);
        }

        Bank next;
        int flag = 0;
        while (!banks.isEmpty()) {
            next = banks.poll();
            toDetermine[flag ^ 1] = new ArrayDeque<>();
            for (Integer i : toDetermine[flag]) {
                if (adj[i].contains(next.index) || i == next.index) toDetermine[flag ^ 1].offer(i);
                else bankMaxTwo[i] = next.level;
            }
            flag ^= 1;
        }

        long res = Long.MAX_VALUE;
        long nextRes;
        for (int i = 0; i < n; i++) {
            nextRes = a[i];
            if (bankMaxOne[i] != Integer.MIN_VALUE) nextRes = Math.max(nextRes, (long) bankMaxOne[i] + 1L);
            if (bankMaxTwo[i] != Integer.MIN_VALUE) nextRes = Math.max(nextRes, (long) bankMaxTwo[i] + 2L);
            res = Math.min(res, nextRes);
        }

        out.print(res);
    }

    private static class Bank implements Comparable<Bank> {
        int index;
        int level;

        public Bank(int index, int level) {
            this.index = index;
            this.level = level;
        }

        @Override
        public int compareTo(Bank o) {
            return Long.compare(o.level, this.level);
        }
    }
}
