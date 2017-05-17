package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] aByInd = new int[100001];
        for (int i = 0; i < n; i++) {
            aByInd[in.nextInt()]++;
        }

        int l = 0;
        int r = 100000;
        int nextRes;
        long res = 0;
        while (r - l > k) {
            if (aByInd[l] != 0 && aByInd[r] != 0) {
                nextRes = Math.min(aByInd[l], aByInd[r]);
                aByInd[l] -= nextRes;
                aByInd[r] -= nextRes;
                aByInd[l + 1] += nextRes;
                aByInd[r - 1] += nextRes;
                res = res + nextRes;
            }
            if (aByInd[l] == 0) l++;
            if (aByInd[r] == 0) r--;
        }
        out.print(res);
    }
}
