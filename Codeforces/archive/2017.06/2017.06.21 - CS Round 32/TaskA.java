package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        boolean isOff = false;
        int res = 0;
        int lastTimeOn = 0;
        int value;
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 1) {
                value = in.nextInt();
                if (!isOff) {
                    lastTimeOn = value;
                }
                isOff = true;
            } else {
                value = in.nextInt();
                if (isOff) {
                    res += (value - lastTimeOn);
                }
                isOff = false;
            }
        }

        out.print(res);
    }
}
