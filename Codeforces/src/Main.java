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
        private static final int INF = Integer.MAX_VALUE / 4;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] strings = new char[n][m];
            for (int i = 0; i < n; i++) strings[i] = in.next().toCharArray();

            int[][] info = new int[n][3];
            for (int i = 0; i < n; i++) Arrays.fill(info[i], INF);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (strings[i][j] >= '0' && strings[i][j] <= '9')
                        info[i][0] = Math.min(info[i][0], Math.min(j, m - j));
                    else if (strings[i][j] >= 'a' && strings[i][j] <= 'z')
                        info[i][1] = Math.min(info[i][1], Math.min(j, m - j));
                    else info[i][2] = Math.min(info[i][2], Math.min(j, m - j));
                }
            }

            int res = INF;
            int currentRes;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        currentRes = info[i][0] + info[j][1] + info[k][2];
                        if (i == j || j == k || i == k) currentRes = INF;
                        res = Math.min(currentRes, res);
                    }
                }
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

