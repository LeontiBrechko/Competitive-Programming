package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String first = in.next();
        String second = in.next();
        String text = in.next();
        StringBuilder res = new StringBuilder();
        boolean isUpper;
        char next;
        for (int i = 0; i < text.length(); i++) {
            next = text.charAt(i);
            isUpper = false;
            if (next < 'a' || next > 'z') {
                if (next >= '0' && next <= '9') {
                    res.append(next);
                    continue;
                }
                isUpper = true;
            }
            res.append(isUpper ?
                    (second.charAt(first.indexOf((next + "").toLowerCase())) + "").toUpperCase() :
                    second.charAt(first.indexOf((next + "").toLowerCase())));
        }
        out.print(res);
    }
}
