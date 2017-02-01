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
        private static final long INF = Long.MAX_VALUE / 2L;
        int n;
        int m;
        int k;
        int[] c;
        int[][] p;
        long[][][] dp;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            c = in.nextIntArray(n);
            p = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    p[i][j] = in.nextInt();
                }
            }

            dp = new long[2][k + 1][m];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k + 1; j++) {
                    Arrays.fill(dp[i][j], INF);
                }
            }

            if (c[0] == 0) for (int i = 0; i < m; i++) dp[0][1][i] = p[0][i];
            else dp[0][1][c[0] - 1] = 0;

            int nextIndex = 0;
            for (int i = 1; i < n; i++) {
                nextIndex ^= 1;
                for (int j = 0; j < k + 1; j++) Arrays.fill(dp[nextIndex][j], INF);
                for (int j = 1; j < k + 1; j++) {
                    if (c[i] == 0) {
                        for (int l = 0; l < m; l++) {
                            dp[nextIndex][j][l] =
                                    Math.min(dp[nextIndex][j][l], dp[nextIndex ^ 1][j][l] + p[i][l]);
                            for (int o = 0; o < m; o++)
                                if (o != l)
                                    dp[nextIndex][j][l] =
                                            Math.min(dp[nextIndex][j][l], dp[nextIndex ^ 1][j - 1][o] + p[i][l]);
                        }
                    } else {
                        dp[nextIndex][j][c[i] - 1] =
                                Math.min(dp[nextIndex][j][c[i] - 1], dp[nextIndex ^ 1][j][c[i] - 1]);
                        for (int l = 0; l < m; l++) {
                            if (l != c[i] - 1) dp[nextIndex][j][c[i] - 1] =
                                    Math.min(dp[nextIndex][j][c[i] - 1], dp[nextIndex ^ 1][j - 1][l]);
                        }
                    }
                }
            }

            long res = INF;
            for (int i = 0; i < m; i++) res = Math.min(res, dp[nextIndex][k][i]);
            out.print(res == INF ? -1 : res);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextInt();
            }
            return array;
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

