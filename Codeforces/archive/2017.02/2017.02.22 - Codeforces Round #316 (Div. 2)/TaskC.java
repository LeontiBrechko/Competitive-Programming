package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int segmentCount = 0;
        int length = 0;
        boolean[] s = new boolean[n];
        String S = in.next();
        for (int i = 0; i < n; i++) {
            s[i] = S.charAt(i) == '.';
            if (s[i]) {
                length++;
                if (i == 0 || !s[i - 1]) segmentCount++;
            }
        }

        int nextPos;
        char nextChar;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m; i++) {
            nextPos = in.nextInt() - 1;
            nextChar = in.next().charAt(0);
            if (s[nextPos] && nextChar != '.') {
                length--;
                if (nextPos > 0 && nextPos < n - 1) {
                    if (s[nextPos - 1] && s[nextPos + 1]) segmentCount++;
                    else if (!s[nextPos - 1] && !s[nextPos + 1]) segmentCount--;
                } else {
                    if ((nextPos > 0 && !s[nextPos - 1]) || (nextPos < n - 1 && !s[nextPos + 1]) ||
                            (nextPos <= 0 && nextPos >= n - 1))
                        segmentCount--;
                }
                s[nextPos] = false;
            } else if (nextChar == '.' && !s[nextPos]) {
                length++;
                if (nextPos > 0 && nextPos < n - 1) {
                    if (s[nextPos - 1] && s[nextPos + 1]) segmentCount--;
                    else if (!s[nextPos - 1] && !s[nextPos + 1]) segmentCount++;
                } else {
                    if ((nextPos > 0 && !s[nextPos - 1]) || (nextPos < n - 1 && !s[nextPos + 1]) ||
                            (nextPos <= 0 && nextPos >= n - 1))
                        segmentCount++;
                }
                s[nextPos] = true;
            }
            res.append(length - segmentCount).append("\n");
        }
        out.print(res);
    }

}
