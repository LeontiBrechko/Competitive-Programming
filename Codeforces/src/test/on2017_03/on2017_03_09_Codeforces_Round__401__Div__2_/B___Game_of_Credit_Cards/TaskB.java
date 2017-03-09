package test.on2017_03.on2017_03_09_Codeforces_Round__401__Div__2_.B___Game_of_Credit_Cards;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer[] first = new Integer[n];
        Integer[] second = new Integer[n];
        String next = in.next();
        for (int i = 0; i < n; i++) first[i] = next.charAt(i) - '0';
        next = in.next();
        for (int i = 0; i < n; i++) second[i] = next.charAt(i) - '0';
        Arrays.sort(first);
        Arrays.sort(second);

        int res1 = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            while (j < n && first[i] > second[j]) j++;
            if (j < n) res1++;
        }
        int res2 = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            while (j < n && first[i] >= second[j]) j++;
            if (j < n) res2++;
        }
        out.printf("%d\n%d", n - res1, res2);
    }
}
