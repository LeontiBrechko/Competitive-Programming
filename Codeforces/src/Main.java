import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskE {
        int n;
        int m;
        int[] w;
        int[] c;
        HashMap<Integer, HashMap<Integer, Long>> dp;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            w = new int[n];
            c = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = in.nextInt();
                c[i] = in.nextInt();
            }
            dp = new HashMap<>();
            for (int i = 0; i < n; i++) dp.put(i, new HashMap<>());
            out.print(knapsack(0, m));
        }

        private long knapsack(int id, int remaining) {
            if (remaining == 0) return 0;
            if (remaining < 0) return Integer.MIN_VALUE;
            if (id == n) return 0;
            if (dp.get(id).getOrDefault(remaining, -1L) != -1) return dp.get(id).get(remaining);

            long result = Math.max(knapsack(id + 1, remaining - w[id]) + c[id], knapsack(id + 1, remaining));
            dp.get(id).put(remaining, result);
            return result;
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

