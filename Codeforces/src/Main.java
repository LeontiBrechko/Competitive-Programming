import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String a = in.next();
            String b = in.next();
            int aLen = a.length();
            int bLen = b.length();

            int INF = Integer.MAX_VALUE / 2;

            int[] p = new int[bLen + 1];
            int[] s = new int[bLen + 1];
            Arrays.fill(p, INF);
            Arrays.fill(s, INF);
            p[0] = 0;
            s[bLen] = 0;

            for (int i = 0, j = 1; i < aLen && j <= bLen; i++) {
                if (a.charAt(i) == b.charAt(j - 1)) {
                    p[j] = i + 1;
                    j++;
                }
            }
            for (int i = aLen - 1, j = bLen - 1; i >= 0 && j >= 0; i--) {
                if (a.charAt(i) == b.charAt(j)) {
                    s[j] = aLen - i;
                    j--;
                }
            }

            int low, high, mid, currentRes, resStart = 0, resFinish = bLen;
            for (int i = 0; i <= bLen && p[i] != INF; i++) {
                low = i;
                high = bLen;
                currentRes = high;
                while (low < high) {
                    mid = (low + high) >>> 1;
                    if (p[i] + s[mid] <= aLen) {
                        currentRes = Math.min(currentRes, mid);
                        high = mid;
                    } else low = mid + 1;
                }
                if (currentRes - i < resFinish - resStart) {
                    resFinish = currentRes;
                    resStart = i;
                }
            }
            String res = b.substring(0, resStart) + (resFinish < bLen ? b.substring(resFinish, bLen) : "");
            out.print(res.equals("") ? "-" : res);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
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

