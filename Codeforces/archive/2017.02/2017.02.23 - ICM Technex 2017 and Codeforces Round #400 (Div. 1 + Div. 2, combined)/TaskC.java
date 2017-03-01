package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final long MAX_POWER = (long) 10e16;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        HashSet<Long> powers = new HashSet<>();
        HashMap<Long, Integer> subarrays = new HashMap<>();
        if (k == 1) {
            powers.add(1L);
        } else if (k == -1) {
            powers.add(1L);
            powers.add(-1L);
        } else {
            powers.add(1L);
            long nextPower = k;
            for (; nextPower < MAX_POWER; ) {
                powers.add(nextPower);
                nextPower = nextPower * ((long) k);
            }
        }
        long sum = 0;
        subarrays.put(0L, 1);
        long res = 0;
        long nextNeeded;
        for (int i = 0; i < n; i++) {
            sum += ((long) in.nextInt());
            for (Long power : powers) {
                nextNeeded = sum - power;
                if (subarrays.containsKey(nextNeeded)) {
                    res += subarrays.get(nextNeeded);
                }
            }
            subarrays.put(sum, subarrays.getOrDefault(sum, 0) + 1);
        }
        out.print(res);
    }
}
