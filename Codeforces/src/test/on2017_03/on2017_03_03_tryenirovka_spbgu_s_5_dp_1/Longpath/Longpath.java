package test.on2017_03.on2017_03_03_tryenirovka_spbgu_s_5_dp_1.Longpath;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Longpath {
    private static final int MAX = 100001;

    int n, m;
    ArrayList<Integer>[] adj;
    ArrayDeque<Integer> topology;
    int[] dp;
    boolean[] isVisited;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) adj[in.nextInt() - 1].add(in.nextInt() - 1);

        topology = new ArrayDeque<>();
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) dfs(i);
        }

        dp = new int[n];
        for (Integer u : topology) {
            for (Integer v : adj[u]) {
                if (dp[u] + 1 > dp[v]) dp[v] = dp[u] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, dp[i]);
        out.print(res);
    }

    private void dfs(int u) {
        isVisited[u] = true;
        for (Integer v : adj[u]) if (!isVisited[v]) dfs(v);
        topology.push(u);
    }

}
