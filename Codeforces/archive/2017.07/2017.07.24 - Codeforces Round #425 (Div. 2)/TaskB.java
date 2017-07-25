package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    private static final int ALPH = 26;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        boolean[] isOk = new boolean[ALPH];
        String good = in.next();
        for (int i = 0; i < good.length(); i++) isOk[good.charAt(i) - 'a'] = true;

        String s = in.next();
        int n = in.nextInt();
        int starIndex = s.indexOf('*');
        if (starIndex == -1) starIndex = s.length();

        String next;
        int length, end;
        boolean isPossible;
        while (n-- > 0) {
            next = in.next();
            end = length = next.length();
            isPossible = !(starIndex == s.length() && s.length() != next.length());

            for (int i = 0; i < starIndex && isPossible; i++) {
                if (i >= length) {
                    isPossible = false;
                    continue;
                }

                if (s.charAt(i) == '?' && !isOk[next.charAt(i) - 'a']) isPossible = false;
                else if (s.charAt(i) != '?' && next.charAt(i) != s.charAt(i)) isPossible = false;
            }

            for (int i = length - 1, j = s.length() - 1; j > starIndex && isPossible; i--, j--) {
                if (i < 0 || i < starIndex) {
                    isPossible = false;
                    continue;
                }

                if (s.charAt(j) == '?' && !isOk[next.charAt(i) - 'a']) isPossible = false;
                else if (s.charAt(j) != '?' && next.charAt(i) != s.charAt(j)) isPossible = false;

                end = i;
            }

            for (int i = starIndex; i < end && isPossible; i++) {
                if (i >= length) {
                    isPossible = false;
                    continue;
                }

                if (isOk[next.charAt(i) - 'a']) isPossible = false;
            }

            out.println(isPossible ? "YES" : "NO");
        }
    }
}
