package test.on2017_01.on2017_01_05_Codeforces_Round__383__Div__2_.A___Arpa_s_hard_exam_and_Mehrdad_s_naive_cheat;



import lib.util.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        if (n == 0) {
            out.print(1);
            return;
        }
        int res = n % 4;
        switch (res) {
            case 0:
                out.print(6);
                break;
            case 1:
                out.print(8);
                break;
            case 2:
                out.print(4);
                break;
            case 3:
                out.print(2);
                break;
        }
    }
}
