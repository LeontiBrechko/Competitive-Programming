package test.on2017_04.on2017_04_28_2016_2017_ACM_ICPC_Pacific_Northwest_Regional_Contest__Div__2_.TaskQ;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskQ {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Integer> times = new PriorityQueue<>();
        for (int i = 0; i < k; i++) times.offer(in.nextInt());

        long res = 0;
        long current = 0;
        int index = k;
        while (!times.isEmpty()) {
            current = current + times.poll();
            res += current;
            if (k++ < n) times.offer(in.nextInt());
        }

        out.print(res);
    }
}
