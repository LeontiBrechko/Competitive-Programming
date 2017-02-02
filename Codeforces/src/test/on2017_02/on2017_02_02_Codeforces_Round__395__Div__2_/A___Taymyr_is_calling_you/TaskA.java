package test.on2017_02.on2017_02_02_Codeforces_Round__395__Div__2_.A___Taymyr_is_calling_you;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int z = in.nextInt();
        long aS = 0;
        long bS = 0;
        HashSet<Long> a = new HashSet<>();
        HashSet<Long> b = new HashSet<>();

        while (aS + n <= z) {
            aS += (long) n;
            a.add(aS);
        }

        while (bS + m <=  z) {
            bS += (long) m;
            b.add(bS);
        }

        long res = 0;
        for (Long i : b) {
            if (a.contains(i)) res++;
        }

        out.print(res);
    }
}
