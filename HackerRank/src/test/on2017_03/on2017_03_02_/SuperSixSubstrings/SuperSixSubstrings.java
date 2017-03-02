package test.on2017_03.on2017_03_02_.SuperSixSubstrings;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class SuperSixSubstrings {
    String number;
    long res;
    long[][] dp;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        number = in.next();
        res = 0;
        dp = new long[number.length()][3];
        for (int i = 0; i < number.length(); i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') res++;
            else res += isSuper(i, 0);
        }
        out.print(res);
    }

    private long isSuper(int i, int mod) {
        if (i == number.length()) return 0;
        if (dp[i][mod] != -1) return dp[i][mod];
        int digit = number.charAt(i) - '0';
        return dp[i][mod] = isSuper(i + 1, (mod + digit) % 3) + ((mod + digit) % 3 == 0 && digit % 2 == 0 ? 1 : 0);
    }
}
