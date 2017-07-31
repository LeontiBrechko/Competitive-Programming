package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Map<Integer, Integer> numbers = new TreeMap<>();
        for (int i = 0; i < n; i++) numbers.put(in.nextInt(), i);

        int currentPos = -1;
        long res = 0;
        int nextDist;
        for (Integer number : numbers.keySet()) {
            if (currentPos == -1) {
                currentPos = numbers.get(number);
                continue;
            }

            nextDist = Math.abs(currentPos - numbers.get(number));
            res += ((long) Math.min(nextDist, n - nextDist));
            currentPos = numbers.get(number);
        }

        out.print(res);
    }
}
