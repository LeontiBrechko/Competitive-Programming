package test.on2017_03.on2017_03_09_Codeforces_Round__100.A___New_Year_Table;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    private static final double EPSILON = 1e-9;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        double R = in.nextDouble();
        double r = in.nextDouble();

        if (R < 2 * r) {
            if (n > 1 || R < r) out.print("NO");
            else out.print("YES");
            return;
        }

        double a = r + r;
        double b = R - r;
        double angle = (2 * b * b - a * a) / (2 * b * b);
        angle = Math.acos(angle);

        double res = 2 * Math.PI - angle * (n - 1);

        if (res + EPSILON - angle >= 0) out.print("YES");
        else out.print("NO");
    }
}
