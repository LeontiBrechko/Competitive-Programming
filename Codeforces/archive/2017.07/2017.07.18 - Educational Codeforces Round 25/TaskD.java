package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskD {
    private static final int ALPH = 26;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int n = s.length;
        int m = t.length;
        int[] count = new int[ALPH + 1];

        for (int i = 0; i < n; i++) {
            if (s[i] == '?') count[26]++;
            else count[s[i] - 'a']++;
        }
        for (int i = 0, j = 0, current = 0; count[26] > 0; i++) {
            current = t[i % m] - 'a';
            if (count[current] > 0) count[current]--;
            else {
                count[26]--;
                while (j < n && s[j] != '?') j++;
                s[j] = t[i % m];
                j++;
            }
        }

        out.print(String.valueOf(s));
    }
}
