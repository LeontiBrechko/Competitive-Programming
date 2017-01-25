package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();
        int al = a.length();
        int bl = b.length();

        int l = -1;
        int r = bl;
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> ri = new ArrayList<>();

        for (int i = 0; i < al && l < bl - 1; i++) {
            if (a.charAt(i) == b.charAt(l + 1)) {
                l++;
                li.add(i);
            }
        }
        for (int i = al - 1; i >= 0 && r > 0; i--) {
            if (a.charAt(i) == b.charAt(r - 1)) {
                r--;
                ri.add(i);
            }
        }

        Collections.sort(ri);
        if (l == -1 && r == bl) {
            out.print("-");
            return;
        }
        if (li.size() == 0) {
            out.print(b.substring(r, bl));
            return;
        }

        
    }
}
