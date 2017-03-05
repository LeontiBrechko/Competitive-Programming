package test.on2017_03.on2017_03_04_VK_Cup_2017________________1.B___________________;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("Duplicates")
public class TaskB {
    private static final int MAX = 101;


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        SortedMap<Integer, ArrayList<Integer>> limits = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (i > 0) {
                if (!limits.containsKey(a[i])) limits.put(a[i], new ArrayList<>());
                limits.get(a[i]).add(i);
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] doesKnow = new boolean[n];
        StringBuilder res = new StringBuilder();
        int resCount = 0;

        queue.offer(0);
        doesKnow[0] = true;

        int nextGuy;
        ArrayList<Integer> guysToTell;
        ArrayList<Integer> losers;
        while (!queue.isEmpty()) {
            nextGuy = queue.poll();

            while (a[nextGuy] > 0 && limits.size() > 0) {
                guysToTell = limits.get(limits.firstKey());
                for (Integer guy : guysToTell) {
                    if (a[nextGuy] <= 0) break;
                    doesKnow[guy] = true;
                    queue.offer(guy);
                    a[nextGuy]--;
                    resCount++;
                    res.append(String.format("%d %d\n", nextGuy + 1, guy + 1));
                }

                losers = new ArrayList<>();
                for (Integer guy : guysToTell) if (!doesKnow[guy]) losers.add(guy);
                if (losers.size() == 0) limits.remove(limits.firstKey());
                else limits.put(limits.firstKey(), losers);
            }
        }

        boolean isPossible = true;
        for (Boolean i : doesKnow) {
            if (!i) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            out.println(resCount);
            out.print(res);
        } else out.print(-1);
    }
}
