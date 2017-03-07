package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    int tLength, pLength;
    String t, p;
    int[] a, aIndex;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        t = in.next();
        p = in.next();
        tLength = t.length();
        pLength = p.length();
        a = new int[tLength];
        aIndex = new int[tLength];
        for (int i = 0; i < tLength; i++) aIndex[a[i] = in.nextInt() - 1] = i;

        int low = 0;
        int high = tLength;
        int mid;
        while (low < high) {
            mid = (low + high + 1) >>> 1;
            if (isPossible(mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        out.print(low);
    }

    private boolean isPossible(int numberToDelete) {
        int length = 0;
        for (int i = 0, j = 0; i < tLength && j < pLength; i++) {
            if (aIndex[i] >= numberToDelete && t.charAt(i) == p.charAt(j)) {
                length++;
                j++;
            }
        }
        return length == pLength;
    }
}
