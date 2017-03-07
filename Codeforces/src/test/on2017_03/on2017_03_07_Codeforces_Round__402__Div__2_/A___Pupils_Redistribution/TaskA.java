package test.on2017_03.on2017_03_07_Codeforces_Round__402__Div__2_.A___Pupils_Redistribution;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] countA = new int[5];
        int[] countB = new int[5];
        for (int i = 0; i < n; i++) countA[in.nextInt() - 1]++;
        for (int i = 0; i < n; i++) countB[in.nextInt() - 1]++;

        int res = 0;
        int nextRequired;
        int aSpace, bSpace;
        aSpace = bSpace = 0;
        for (int i = 0; i < 5; i++) {
            if ((countA[i] + countB[i]) % 2 == 1) {
                res = -1;
                break;
            } else {
                nextRequired = (countA[i] + countB[i]) / 2;
                if (nextRequired > countA[i]) {
                    aSpace += (nextRequired - countA[i]);
                } else if (nextRequired > countB[i]) {
                    bSpace += (nextRequired - countB[i]);
                }
            }
        }

        if (res == -1 || aSpace != bSpace) {
            out.print(-1);
        } else out.print(aSpace);
    }
}
