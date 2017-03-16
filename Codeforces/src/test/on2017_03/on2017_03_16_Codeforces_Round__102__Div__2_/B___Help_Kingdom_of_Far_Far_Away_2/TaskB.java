package test.on2017_03.on2017_03_16_Codeforces_Round__102__Div__2_.B___Help_Kingdom_of_Far_Far_Away_2;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String number = in.next();
        int n = number.length();
        boolean isNegative = number.charAt(0) == '-';
        StringBuilder res = new StringBuilder();
        int i = number.indexOf('.') - 1;
        if (i == -2) i = n - 1;
        int j = 0;
        while (i > (isNegative ? 0 : -1)) {
            if (j == 3) {
                res.append(',');
                j = 0;
            }
            j++;
            res.append(number.charAt(i--));
        }

        res.append('$');
        if (isNegative) res.append('(');
        res.reverse();
        res.append('.');
        i = number.indexOf('.') + 1;
        if (i != 0) {
            j = 0;
            while (j++ < 2) {
                if (i < n) res.append(number.charAt(i++));
                else res.append('0');
            }
        } else {
            res.append("00");
        }
        if (isNegative) res.append(')');
        out.print(res);
    }
}
