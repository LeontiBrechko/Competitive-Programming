package test.on2017_04.on2017_04_26_2016_2017_ACM_ICPC_Pacific_Northwest_Regional_Contest__Div__2_.TaskP;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskP {
    int n, k, r, res, has;
    int[] bit;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        r = in.nextInt();
        bit = new int[n + 1];
        res = 0;
        for (int i = 0; i < k; i++) increaseValue(in.nextInt(), 1);
        for (int i = r; i <= n; i++) {
            has = query(i - r + 1, i);
            if (has < 2) {
                for (int j = i; j > i - r && has < 2; j--) {
                    if (query(i, i) == 0) {
                        increaseValue(i, 1);
                        has++;
                        res++;
                    }
                }
            }
        }
        out.print(res);
    }

    private void increaseValue(int index, int value) {
        for (; index < bit.length; index += index & -index) {
            bit[index] += value;
        }
    }

    private int query(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index) {
            sum += bit[index];
        }
        return sum;
    }

    private int query(int l, int r) {
        return query(r) - query(l - 1);
    }
}
