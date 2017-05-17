package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("Duplicates")
public class TaskN {
    int n, m, size;
    int[] b, p;
    long currentWeight;
    boolean found;
    Map<Long, ArrayList<Integer>> map;
    HashSet<Long> weights;
    TreeSet<Long> res;
    StringBuilder answer;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        b = in.nextIntArray(n);
        p = in.nextIntArray(m);
        map = new HashMap<>();
        weights = new HashSet<>();
        res = new TreeSet<>();
        answer = new StringBuilder();

        for (int i = 0; i < (1 << m); i++) {
            currentWeight = 0;
            for (int j = 0; j < m; j++) if ((i & (1 << j)) != 0) currentWeight += (long) p[j];
            if (!map.containsKey(currentWeight)) map.put(currentWeight, new ArrayList<>());
            map.get(currentWeight).add(i);
        }

        for (Map.Entry<Long, ArrayList<Integer>> entry : map.entrySet()) {
            size = entry.getValue().size();
            if (size < 2) continue;
            found = false;
            for (int i = 0; i < size && !found; i++) {
                for (int j = 0; j < size && !found; j++) {
                    if ((entry.getValue().get(i) & entry.getValue().get(j)) == 0) {
                        found = true;
                        weights.add(entry.getKey() * 2L);
                    }
                }
            }
        }
        weights.add(0L);

        for (int i = 0; i < n; i++) {
            for (Long weight : weights) {
                res.add(weight + b[i]);
            }
        }

        for (Long r : res) answer.append(r).append('\n');
        out.print(answer);
    }
}
