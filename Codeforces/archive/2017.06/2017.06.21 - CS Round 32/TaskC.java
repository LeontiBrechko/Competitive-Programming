package tasks;

import lib.util.InputReader;
import test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.A___Santa_Claus_and_a_Place_in_a_Class.Main;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) total |= a[i] = in.nextInt();

        int[] lastOccurences = new int[32];
        Arrays.fill(lastOccurences, -1);
        int res = n;
        int current, l;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((a[i] & (1 << j)) > 0) {
                    lastOccurences[j] = i;
                }
            }

            current = 0;
            l = i;
            for (int j = 0; j < 32; j++) {
                if (lastOccurences[j] > -1) {
                    l = Math.min(l, lastOccurences[j]);
                    current |= (1 << j);
                }
            }

            if (current == total) {
                res = Math.min(res, i - l + 1);
            }
        }

        out.print(res);
    }
}
