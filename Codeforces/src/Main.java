import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<Integer>[] adj = new ArrayList[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
            int u, v;
            for (int i = 0; i < n - 1; i++) {
                u = in.nextInt() - 1;
                v = in.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            int[] c = new int[n];
            for (int i = 0; i < n; i++) c[i] = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (Integer j : adj[i]) {
                    if (c[i] != c[j]) {
                        if (dfs(n, adj, c, i)) {
                            out.printf("YES\n%d", i + 1);
                            return;
                        } else if (dfs(n, adj, c, j)) {
                            out.printf("YES\n%d", j + 1);
                            return;
                        } else {
                            out.print("NO");
                            return;
                        }
                    }
                }
            }

            out.print("YES\n1");
        }

        private boolean dfs(int n, ArrayList<Integer>[] adj, int[] c, int root) {
            boolean[] isVisited;
            ArrayDeque<Integer> stack;
            int u;

            for (Integer i : adj[root]) {
                isVisited = new boolean[n];
                stack = new ArrayDeque<>();
                isVisited[root] = true;
                isVisited[i] = true;
                stack.push(i);
                boolean isOk = true;
                while (!stack.isEmpty()) {
                    if (!isOk) break;
                    u = stack.poll();
                    for (Integer v : adj[u]) {
                        if (!isVisited[v]) {
                            isOk = isOk && c[v] == c[i];
                            isVisited[v] = true;
                            stack.push(v);
                        }
                    }
                }
                if (!isOk) return false;
            }
            return true;
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

