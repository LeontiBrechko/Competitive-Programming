package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();
        int aLen = a.length();
        int bLen = b.length();

        int INF = Integer.MAX_VALUE / 2;

        int[] p = new int[bLen + 1];
        int[] s = new int[bLen + 1];
        Arrays.fill(p, INF);
        Arrays.fill(s, INF);
        p[0] = 0;
        s[bLen] = 0;

        for (int i = 0, j = 1; i < aLen && j <= bLen; i++) {
            if (a.charAt(i) == b.charAt(j - 1)) {
                p[j] = i + 1;
                j++;
            }
        }
        for (int i = aLen - 1, j = bLen - 1; i >= 0 && j >= 0; i--) {
            if (a.charAt(i) == b.charAt(j)) {
                s[j] = aLen - i;
                j--;
            }
        }

        int low, high, mid, currentRes, resStart = 0, resFinish = bLen;
        for (int i = 0; i <= bLen && p[i] != INF; i++) {
            low = i;
            high = bLen;
            currentRes = high;
            while (low < high) {
                mid = (low + high) >>> 1;
                if (p[i] + s[mid] <= aLen) {
                    currentRes = Math.min(currentRes, mid);
                    high = mid;
                }
                else low = mid + 1;
            }
            if (currentRes - i < resFinish - resStart) {
                resFinish = currentRes;
                resStart = i;
            }
        }
        String res = b.substring(0, resStart) + (resFinish < bLen ? b.substring(resFinish, bLen) : "");
        out.print(res.equals("") ? "-" : res);
    }
}
