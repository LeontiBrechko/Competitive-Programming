package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskC {
    private static final int INF = 2000000000;
    int n, m, t;
    ArrayList<Edge>[] adj;
    int[][] path, dp;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        t = in.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int u, v;
        for (int i = 0; i < m; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            adj[u].add(new TaskC.Edge(v, in.nextInt()));
        }

        dp = new int[n][n];
        path = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
            Arrays.fill(path[i], -1);
        }
        dp[n - 1][0] = 0;

        int next, nextV;
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            next = next(0, i);
            if (next <= t) {
                res.append(i + 1).append("\n");
                nextV = 0;
                while (nextV != -1) {
                    res.append(nextV + 1).append(" ");
                    nextV = path[nextV][i--];
                }
                break;
            }
        }
        out.print(res);
    }

    private int next(int city, int visited) {
        if (visited < 0) return INF;
        if (city == n - 1) return visited == 0 ? 0 : INF;
        if (dp[city][visited] != INF) return dp[city][visited];

        long res = INF - 1;
        long next;
        for (TaskC.Edge e : adj[city]) {
            next = (long) next(e.v, visited - 1) + e.t;
            if (next < res) {
                res = next;
                path[city][visited] = e.v;
            }
        }

        return dp[city][visited] = (int) res;
    }

    private static class Edge {
        int v;
        int t;

        public Edge(int v, int t) {
            this.v = v;
            this.t = t;
        }

    }
}
