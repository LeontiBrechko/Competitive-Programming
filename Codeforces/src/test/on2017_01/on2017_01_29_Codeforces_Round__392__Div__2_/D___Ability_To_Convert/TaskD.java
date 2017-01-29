package test.on2017_01.on2017_01_29_Codeforces_Round__392__Div__2_.D___Ability_To_Convert;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        String k = in.next();

        if (n <= 10) {
            out.print(new BigInteger(k, (int) n).toString());
            return;
        }

        long res = 0;
        long next = -1;
        int j, z;
        String nextSub;
        ArrayList<Long> numbers = new ArrayList<>();
        for (int i = k.length() - 1; i >= 0;) {
            j = i;
            while (j >= 0 && (next = Long.parseLong(k.substring(j, i + 1))) < n)
                j--;
            if (next >= n) {
                nextSub = k.substring(Math.min(j + 1, i), i + 1);
                next = Long.parseLong(nextSub);
                z = 0;
                while (z < nextSub.length() && nextSub.charAt(z) == '0') {
                    j++;
                    z++;
                    next = Long.parseLong(k.substring(Math.min(j + 1, i), i + 1));
                }
                if (next == 0) i--;
                else i = Math.min(i, j);
            } else if (next == 0) {
                i--;
            } else i = j - 1;
            numbers.add(next);
        }
        for (int i = numbers.size() - 1; i >= 0; i--) {
            res = res * n + numbers.get(i);
        }
        out.print(res);
    }
}
