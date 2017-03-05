package tasks;

import lib.util.InputReader;
import test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.A___Santa_Claus_and_a_Place_in_a_Class.Main;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    int n;
    double[] x, v;
    double max, min;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        x = new double[n];
        v = new double[n];
        min = 1;
        max = 10e9;
        for (int i = 0; i < n; i++) x[i] = in.nextDouble();
        for (int i = 0; i < n; i++) v[i] = in.nextDouble();

        double low = 0.0D;
        double high = 10e9;
        double mid;
        double res = high;
        while (high - low > 0.0000001) {
            mid = (high + low) / 2;
            if (isPossible(mid)) {
                res = Math.min(res, mid);
                high = mid;
            } else low = mid;
        }

        out.print(res);
    }

    private boolean isPossible(double time) {
        double nextRange = v[0] * time;
        double low = Math.max(min, x[0] - nextRange);
        double high = Math.min(max, x[0] + nextRange);
        double nextHigh, nextLow;
        boolean isPossible = true;
        for (int i = 1; i < n; i++) {
            nextRange = v[i] * time;
            nextLow = Math.max(min, x[i] - nextRange);
            nextHigh = Math.min(max, x[i] + nextRange);
            if (nextHigh < low || nextLow > high) {
                isPossible = false;
                break;
            } else {
                low = Math.max(low, nextLow);
                high = Math.min(nextHigh, high);
            }
        }

        return isPossible;
    }

    private double timeNeeded(double position) {
        double nextTime;
        double res = -1;
        for (int i = 0; i < n; i++) {
            nextTime = Math.abs(position - x[i]) / v[i];
            res = Math.max(nextTime, res);
        }
        return res;
    }
}
