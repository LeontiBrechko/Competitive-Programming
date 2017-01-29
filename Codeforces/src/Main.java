import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextLong();
            String k = in.next();

            if (n <= 10) {
                out.print(new BigInteger(k, (int) n).toString());
                return;
            }

            long res = 0;
            long next = -1;
            int j, z;
            String nextSub;
            ArrayList<Long> numbers = new ArrayList<>();
            for (int i = k.length() - 1; i >= 0; ) {
                j = i;
                while (j >= 0 && (next = Long.parseLong(k.substring(j, i + 1))) < n)
                    j--;
                if (next >= n) {
                    nextSub = k.substring(Math.min(j + 1, i), i + 1);
                    next = Long.parseLong(nextSub);
                    z = 0;
                    while (z < nextSub.length() && nextSub.charAt(z) == '0') {
                        j++;
                        z++;
                        next = Long.parseLong(k.substring(Math.min(j + 1, i), i + 1));
                    }
                    if (next == 0) i--;
                    else i = Math.min(i, j);
                } else if (next == 0) {
                    i--;
                } else i = j - 1;
                numbers.add(next);
            }
            for (int i = numbers.size() - 1; i >= 0; i--) {
                res = res * n + numbers.get(i);
            }
            out.print(res);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
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

