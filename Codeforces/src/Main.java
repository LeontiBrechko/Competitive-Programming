import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long b1 = in.nextInt();
            int q = in.nextInt();
            int l = in.nextInt();
            int m = in.nextInt();
            HashSet<Long> a = new HashSet<>();
            for (int i = 0; i < m; i++) {
                a.add(in.nextLong());
            }

            if (Math.abs(b1) > l) out.print(0);
            else if (b1 == 0 || q == 1) {
                if (a.contains(b1)) out.print(0);
                else out.print("inf");
            } else if (q == -1) {
                if (a.contains(b1) && a.contains(-b1)) out.print(0);
                else out.print("inf");
            } else if (q == 0) {
                if (a.contains(0L)) {
                    if (a.contains(b1)) out.print(0);
                    else out.print(1);
                } else out.print("inf");
            } else {
                long res = 0;
                long b = b1;
                while (Math.abs(b) <= l) {
                    if (!a.contains(b)) res++;
                    b = b * (long) q;
                }
                out.print(res);
            }
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

        public long nextLong() {
            return Long.parseLong(next());
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

