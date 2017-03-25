package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int k;
        boolean isOk;
        Set<Integer> set;
        for (int i = 0; i < m; i++) {
            isOk = false;
            set = new HashSet<>();

            k = in.nextInt();
            for (int j = 0; j < k; j++) set.add(in.nextInt());
            for (Integer v : set) {
                if (set.contains(-v)) {
                    isOk = true;
                    break;
                }
            }

            if (!isOk) {
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }
}
