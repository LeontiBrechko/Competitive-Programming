package test.on2017_02.on2017_02_20_Divide_by_Zero_2017_and_Codeforces_Round__399__Div__1___Div__2__combined_.A___Oath_of_the_Night_s_Watch;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int res = 0;
        int less, greater;
        boolean isLessOk, isGreaterOk;
        for (int i = 0; i < n; i++) {
            less = Arrays.binarySearch(a, a[i] - 1);
            greater = Arrays.binarySearch(a, a[i] + 1);
            isLessOk = isGreaterOk = false;
            if (less >= 0 || -(less + 1) > 0) isLessOk = true;
            if (greater > i || -(greater + 1) < n) isGreaterOk = true;
            if (isLessOk && isGreaterOk) res++;
        }
        out.print(res);
    }
}
