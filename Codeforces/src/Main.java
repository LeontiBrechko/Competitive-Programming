import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskD {
        int tLength;
        int pLength;
        String t;
        String p;
        int[] a;
        int[] aIndex;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            t = in.next();
            p = in.next();
            tLength = t.length();
            pLength = p.length();
            a = new int[tLength];
            aIndex = new int[tLength];
            for (int i = 0; i < tLength; i++) aIndex[a[i] = in.nextInt() - 1] = i;

            int low = 0;
            int high = tLength;
            int mid;
            while (low < high) {
                mid = (low + high + 1) >>> 1;
                if (isPossible(mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            out.print(low);
        }

        private boolean isPossible(int numberToDelete) {
            int length = 0;
            for (int i = 0, j = 0; i < tLength && j < pLength; i++) {
                if (aIndex[i] >= numberToDelete && t.charAt(i) == p.charAt(j)) {
                    length++;
                    j++;
                }
            }
            return length == pLength;
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

