package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskD {
    int n, q, log2n;
    ArrayList<Integer>[] adj;
    int[][] dp;
    int[] parent;
    int[] depth;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        q = in.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int p;
        for (int i = 1; i < n; i++) {
            p = in.nextInt() - 1;
            adj[i].add(p);
            adj[p].add(i);
        }

        log2n = 31 - Integer.numberOfLeadingZeros(n);
        dp = new int[n][log2n + 1];
        parent = new int[n];
        depth = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        dfs(0, 0, isVisited);

        for (int i = 0; i < n; i++) dp[i][0] = parent[i];
        for (int j = 1; j <= log2n; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
            }
        }


        int nextRes;
        int[] values;
        while (q-- > 0) {
            nextRes = 1;
            values = new int[3];
            for (int i = 0; i < 3; i++) values[i] = in.nextInt() - 1;
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    if (a == b) continue;
                    for (int c = 0; c < 3; c++) {
                        if (a == c || b == c) continue;

                        nextRes = Math.max(nextRes, count(values[a], values[b], values[c]));
                    }
                }
            }

            out.println(nextRes);
        }
    }

    private int count(int s, int t, int f) {
        int res = 1;
        int lcaS = lca(s, f);
        int lcaT = lca(t, f);
        int lca = lca(s, t);

        if (lcaS == lcaT) res += Math.abs(depth[lca] - depth[lcaS]);
        return res + Math.abs(Math.max(depth[lcaS], depth[lcaT]) - depth[f]);
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = log2n; i >= 0; i--) {
            if (depth[u] - depth[v] >= (1 << i)) {
                u = dp[u][i];
            }
        }

        if (u == v) return u;

        for (int i = log2n; i >= 0; i--) {
            if (dp[u][i] != dp[v][i]) {
                u = dp[u][i];
                v = dp[v][i];
            }
        }

        return parent[u];
    }

    private void dfs(int u, int d, boolean[] isVisited) {
        for (Integer v : adj[u]) {
            if (!isVisited[v]) {
                depth[v] = d + 1;
                parent[v] = u;
                isVisited[v] = true;
                dfs(v, d + 1, isVisited);
            }
        }
    }
}
