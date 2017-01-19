package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        boolean temp[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (in.nextInt() >= 0) temp[i] = true;
            else count++;
        }

        if (count > k) {
            out.print(-1);
            return;
        }

        int res = 0;
        boolean isSummer = true;
        for (int i = 0; i < n; i++) {
            if (isSummer && !temp[i]) {
                isSummer = false;
                res++;
            } else if (!isSummer && temp[i]) {
                isSummer = true;
            }
            if (!isSummer) k--;
        }
        res += res;

        PriorityQueue<Integer> summerSegments = new PriorityQueue<>();
        isSummer = false;
        int currentSegment = 0;
        int i = 0;
        while (i < n && temp[i]) {
            i++;
        }
        int j = n - 1;
        while (j >= 0 && temp[j]) {
            j--;
        }
        for (; i <= j; i++) {
            if (!isSummer && temp[i]) {
                currentSegment = 1;
                isSummer = true;
            } else if (isSummer && temp[i]) {
                currentSegment++;
            } else if (isSummer && !temp[i]) {
                summerSegments.offer(currentSegment);
                isSummer = false;
            }
        }

        int nextSummerSegment;
        while (k > 0 && !summerSegments.isEmpty()) {
            nextSummerSegment = summerSegments.poll();
            if (nextSummerSegment <= k) {
                k -= nextSummerSegment;
                res -= 2;
            } else break;
        }

        j = n - 1;
        while (j >= 0 && temp[j] && k >= 0) {
            k--;
            j--;
        }

        if (k >= 0 && res > 0) res--;

        out.print(res);
    }
}
