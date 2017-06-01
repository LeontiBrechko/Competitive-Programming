package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        int next = 1;
        while (true) {
            if (next % 2 == 1) {
                if (a < next) {
                    out.print("Vladik");
                    break;
                } else {
                    a -= next;
                }
            } else {
                if (b < next) {
                    out.print("Valera");
                    break;
                } else {
                    b-= next;
                }
            }
            next++;
        }
    }
}
